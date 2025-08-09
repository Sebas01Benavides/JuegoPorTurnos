package juego.personajes;

/*
 * Clase que representa a un personaje de tipo Humano en el juego.
 * Extiende la clase abstracta Personaje e implementa sus métodos abstractos.
 * @author Fabricio Castro V.
 */

import juego.armitas.Arma; // Importa la clase Arma
import java.util.Random;

public class Humano extends Personaje {

    /**
     * Constructor para crear un personaje Humano.
     * @param nombre El nombre del Humano.
     * @param arma El arma que el Humano usará.
     */
    public Humano(String nombre, Arma arma) {
        // Llama al constructor de la clase Personaje (superclase)
        // Asigna valores base para fuerza, defensa y vida máxima de un Humano
        super(nombre, "Humano", 10, 5, 100, arma); 
    }

    /**
     * Implementación del método atacar para el personaje Humano.
     * Calcula el daño basado en el arma y aplica reglas específicas.
     * @param enemigo El personaje al que se va a atacar.
     */
    @Override
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        // Calcula un daño base aleatorio dentro del rango del arma
        int danoBase = random.nextInt(
            this.arma.getDmgMaximo() - this.arma.getDmgMinimo() + 1
        ) + this.arma.getDmgMinimo();

        // Aplica el modificador de daño porcentual del arma
        double danoConModificador = danoBase + (danoBase * this.arma.getModificador());
        int danoTotal = (int) danoConModificador;

        // Lógica específica para un arma con nombre "Escopeta" (ejemplo de bonificación)
        if (this.arma.getNombre().equalsIgnoreCase("Escopeta")) {
            danoTotal += (int)(danoTotal * 0.02); // Añade un +2% de daño extra si es una Escopeta
        }

        // El enemigo recibe el daño calculado
        enemigo.recibirDmg(danoTotal); 
        System.out.println(this.nombre + " ataca con " + this.arma.getNombre() + " causando " + danoTotal + " de daño.");
    }

    /**
     * Implementación del método sanar para el personaje Humano.
     * Cura al personaje en base a la mitad de la vida que le falta hasta su vida máxima.
     */
    @Override
    public void sanar() {
        int curacion = (this.vidaMaxima - this.vidaActual) / 2; // Calcula la curación
        
        // Asegura que al menos se cure 1 punto de vida si no está a vida máxima y puede curarse
        if (curacion <= 0 && this.vidaActual < this.vidaMaxima) { 
            curacion = 1;
        } else if (this.vidaActual == this.vidaMaxima) {
            curacion = 0; // No se cura si ya tiene la vida al máximo
        }

        this.vidaActual += curacion; // Aplica la curación

        // Asegura que la vida no exceda la vida máxima
        if (this.vidaActual > this.vidaMaxima) {
            this.vidaActual = this.vidaMaxima;
        }
        
        // Muestra el mensaje de curación en consola
        if (curacion > 0) {
            System.out.println(this.nombre + " se cura " + curacion + " puntos de vida. Vida actual: " + this.vidaActual);
        } else {
            System.out.println(this.nombre + " no necesita curarse más.");
        }
    }
}