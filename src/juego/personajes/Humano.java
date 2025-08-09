package juego.personajes;

/*
 * @author Fabricio Castro V.
 */

import juego.armitas.Arma; // Importa la clase Arma
import java.util.Random;

public class Humano extends Personaje {

    public Humano(String nombre, Arma arma) {
        // Llama al constructor de la clase Personaje
        // Asumiendo valores base para fuerza, defensa, vida máxima
        super(nombre, "Humano", 10, 5, 100, arma); // Ajustada defensa a 5 para ejemplo
    }

    @Override
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        int danoBase = random.nextInt(
            this.arma.getDmgMaximo() - this.arma.getDmgMinimo() + 1
        ) + this.arma.getDmgMinimo();

        // Aplicar modificador de arma si existe
        double danoConModificador = danoBase + (danoBase * this.arma.getModificador());
        int danoTotal = (int) danoConModificador;

        // Lógica específica para "Escopeta" (como en tu código original)
        if (this.arma.getNombre().equalsIgnoreCase("Escopeta")) {
            danoTotal += (int)(danoTotal * 0.02); // +2%
        }

        enemigo.recibirDmg(danoTotal); // Usa el método actualizado recibirDmg
        System.out.println(this.nombre + " ataca con " + this.arma.getNombre() + " causando " + danoTotal + " de daño.");
    }

    @Override
    public void sanar() {
        int curacion = (this.vidaMaxima - this.vidaActual) / 2; // Cura la mitad de la vida faltante
        if (curacion <= 0 && this.vidaActual < this.vidaMaxima) { // Asegura al menos 1 de curación si no está lleno
            curacion = 1;
        } else if (this.vidaActual == this.vidaMaxima) {
            curacion = 0; // No cura si ya está al máximo
        }

        this.vidaActual += curacion;

        if (this.vidaActual > this.vidaMaxima) {
            this.vidaActual = this.vidaMaxima;
        }
        
        if (curacion > 0) {
            System.out.println(this.nombre + " se cura " + curacion + " puntos de vida. Vida actual: " + this.vidaActual);
        } else {
            System.out.println(this.nombre + " no necesita curarse más.");
        }
    }
}
