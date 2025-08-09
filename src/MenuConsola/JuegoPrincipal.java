package MenuConsola;
import juego.armitas.Arma;
import juego.personajes.Bestia;
import juego.personajes.Elfo;
import juego.personajes.Humano;
import juego.personajes.Personaje;
import java.util.Scanner;
import java.util.Random;
import juego.db.ControladorDeVictorias;
import juego.personajes.Orco;
/**
 *
 * @author sebas
 */
public class JuegoPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Duelo por turnos JAVA");

        // --- Creación de armas ---
        Arma espada = new Arma("Espada Corta", "Melee", 10, 20, 0.05);
        Arma baculo = new Arma("Baculo", "Magica", 12, 25, 0.1);
        Arma garraMay = new Arma("GarraMay", "Melee", 15, 30, 0.04);
        Arma maza = new Arma("Maza", "Melee", 14, 28, 0.07);

        //  Creación del Jugador 1 
        System.out.println("\n Creación del Jugador 1 ");
        Personaje jugador1 = crearPersonaje(scanner, "Jugador 1", espada, baculo, garraMay, maza);

        //  Creación del Jugador 2 
        System.out.println("\n Creación del Jugador 2 ");
        Personaje jugador2 = crearPersonaje(scanner, "Jugador 2", espada, baculo, garraMay, maza);

        System.out.println("\nEl duelo comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre());

        // --- Bucle principal del juego ---
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            if (jugador1.estaVivo()) {
                gestionarTurno(jugador1, jugador2, scanner);
            }
            if (jugador2.estaVivo() && jugador1.estaVivo()) {
                gestionarTurno(jugador2, jugador1, scanner);
            }
        }

        //  Fin del juego
        System.out.println("\n Fin del Duelo");
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha derrotado a " + jugador2.getNombre());
            ControladorDeVictorias.guardarVictoria(jugador1.getNombre());
        } else {
            System.out.println(jugador2.getNombre() + " ha derrotado a " + jugador1.getNombre());
            ControladorDeVictorias.guardarVictoria(jugador2.getNombre());
        }
        
        scanner.close();
    }

    private static Personaje crearPersonaje(Scanner scanner, String etiquetaJugador, Arma espada, Arma baculo, Arma garraMay, Arma maza) {
        System.out.println("Elige tu personaje:");
        System.out.println("1. Humano (fuerza y vida equilibradas)");
        System.out.println("2. Elfo (más ágil y con mejor curación)");
        System.out.println("3. Bestia (alta defensa y ataque poderoso)");
        System.out.println("4. Orco (gran fuerza y resistencia)");
        System.out.print("Elige una opción para " + etiquetaJugador + ": ");
        String eleccion = scanner.nextLine();

        System.out.print("Ingresa el nombre para " + etiquetaJugador + ": ");
        String nombre = scanner.nextLine();

        if (eleccion.equals("1")) {
            return new Humano(nombre, espada);
        } else if (eleccion.equals("2")) {
            return new Elfo(nombre, baculo);
        } else if (eleccion.equals("3")) {
            return new Bestia(nombre, garraMay);
        } else if (eleccion.equals("4")) {
            return new Orco(nombre, maza);
        } else {
            System.out.println("Opción no válida. Se te asignará un Humano por defecto");
            return new Humano(nombre, espada);
        }
    }

    private static void gestionarTurno(Personaje atacante, Personaje defensor, Scanner scanner) {
        System.out.println("\n Turno de " + atacante.getNombre() );
        System.out.println("Vida de " + atacante.getNombre() + ": " + atacante.getVidaActual() + " | Vida de " + defensor.getNombre() + ": " + defensor.getVidaActual());
        System.out.println("Qué deseas hacer?");
        System.out.println("1. Atacar");
        System.out.println("2. Sanar");
        System.out.print("Elige una opción: ");
        String accion = scanner.nextLine();

        switch (accion) {
            case "1":
                atacante.atacar(defensor);
                break;
            case "2":
                atacante.sanar();
                break;
            default:
                System.out.println("Acción no válida. Pierdes tu turno.");
                break;
        }
    }
}