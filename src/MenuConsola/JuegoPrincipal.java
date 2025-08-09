package MenuConsola;
import juego.armitas.Arma;
import juego.personajes.Elfo;
import juego.personajes.Humano;
import juego.personajes.Personaje;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author sebas
 */
public class JuegoPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- ¡Bienvenido a Aventura en la Consola! ---");

        // 1. Creación de Armas
        Arma espada = new Arma("Espada Oxidada", "Melee", 5, 12, 0.0);
        Arma baculo = new Arma("Baculo", "Magica", 8, 18, 0.1);
        Arma arco = new Arma("Arco de Caza", "Rango", 8, 25, 0.08);

        // 2. Creación del jugador (selección de personaje)
        Personaje jugador = null;
        System.out.println("Elige tu personaje:");
        System.out.println("1. Humano (fuerza y vida equilibradas)");
        System.out.println("2. Elfo (más ágil y con mejor curación)");
        System.out.print("Elige una opción: ");
        String eleccion = scanner.nextLine();

        System.out.print("Ingresa el nombre de tu personaje: ");
        String nombreJugador = scanner.nextLine();

        if (eleccion.equals("1")) {
            jugador = new Humano(nombreJugador, espada);
        } else if (eleccion.equals("2")) {
            jugador = new Elfo(nombreJugador, baculo);
        } else {
            System.out.println("Opción no válida. Se te asignará un Humano por defecto.");
            jugador = new Humano(nombreJugador, espada);
        }

        // 3. Creación de un enemigo (puedes crear diferentes tipos aquí)
        Personaje enemigo = new Humano("Orco Malvado", arco);

        System.out.println("\n¡Hola, " + jugador.getNombre() + "! Te enfrentas a un " + enemigo.getNombre() + " con " + enemigo.getVidaActual() + " de vida.");

        // Bucle principal del juego
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            System.out.println("\n--- Turno de " + jugador.getNombre() + " ---");
            System.out.println("Vida de " + jugador.getNombre() + ": " + jugador.getVidaActual() + " | Vida del enemigo: " + enemigo.getVidaActual());
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Sanar");
            System.out.print("Elige una opción: ");
            String accion = scanner.nextLine();

            switch (accion) {
                case "1":
                    jugador.atacar(enemigo);
                    break;
                case "2":
                    jugador.sanar();
                    break;
                default:
                    System.out.println("Acción no válida. Pierdes tu turno.");
                    break;
            }

            // Turno del enemigo, si aún está vivo
            if (enemigo.estaVivo()) {
                System.out.println("\n--- Turno del Enemigo ---");
                enemigo.atacar(jugador);
            }
        }

        // Fin del juego
        System.out.println("\n--- ¡Fin del Juego! ---");
        if (jugador.estaVivo()) {
            System.out.println("¡Felicidades, has derrotado al " + enemigo.getNombre() + "!");
        } else {
            System.out.println("Has sido derrotado. ¡Mejor suerte la próxima vez!");
        }
        
        scanner.close();
    }
}
