package MenuConsola;
import juego.armitas.Arma;
import juego.personajes.Bestia;
import juego.personajes.Elfo;
import juego.personajes.Humano;
import juego.personajes.Personaje;
import java.util.Scanner;
import juego.db.ControladorDeVictorias;
import juego.personajes.Orco;
/**
 *
 * @author sebas
 */
public class JuegoPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Duelo a muerte Java");

        Arma escopeta = new Arma("Escopeta", "fuego", 1, 5, 0.02);
        Arma rifle = new Arma("Rifle francotirador", "fuego", 1, 5, 0.0);
        Arma baculo = new Arma("Baculo", "Magica", 12, 25, 0.1);
        Arma hacha = new Arma("Hacha", "Melee", 14, 28, 0.07);
        Arma martillo = new Arma("Martillo", "Melee", 14, 28, 0.07);
        Arma punos = new Arma("Puños", "Melee", 15, 30, 0.04);
        Arma espada = new Arma("Espada", "Melee", 10, 20, 0.05);

        System.out.println("\n Creación del Jugador 1 ");
        Personaje jugador1 = crearPersonaje(scanner, "Jugador 1", escopeta, rifle, baculo, hacha, martillo, punos, espada);

        System.out.println("\n Creación del Jugador 2 ");
        Personaje jugador2 = crearPersonaje(scanner, "Jugador 2", escopeta, rifle, baculo, hacha, martillo, punos, espada);

        System.out.println("\nEl duelo comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre());

        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            if (jugador1.estaVivo()) {
                gestionarTurno(jugador1, jugador2, scanner);
            }
            if (jugador2.estaVivo() && jugador1.estaVivo()) {
                gestionarTurno(jugador2, jugador1, scanner);
            }
        }

        System.out.println("\n Fin del Duelo ");
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha derrotado a " + jugador2.getNombre());
            ControladorDeVictorias.guardarVictoria(jugador1.getNombre());
        } else {
            System.out.println(jugador2.getNombre() + " ha derrotado a " + jugador1.getNombre());
            ControladorDeVictorias.guardarVictoria(jugador2.getNombre());
        }
        
        scanner.close();
    }

    private static Personaje crearPersonaje(Scanner scanner, String etiquetaJugador, Arma escopeta, Arma rifle, Arma baculo, Arma hacha, Arma martillo, Arma punos, Arma espada) {
        System.out.println("Elige tu personaje:");
        System.out.println("1. Humano (armas de fuego)");
        System.out.println("2. Elfo (magia)");
        System.out.println("3. Orco (hacha o martillo)");
        System.out.println("4. Bestia (puños o espada)");
        System.out.print("Elige una opción para " + etiquetaJugador + ": ");
        String eleccion = scanner.nextLine();

        System.out.print("Ingresa el nombre para " + etiquetaJugador + ": ");
        String nombre = scanner.nextLine();

        if (eleccion.equals("1")) {
            System.out.println("Elige un arma:");
            System.out.println("1. Escopeta");
            System.out.println("2. Rifle francotirador");
            System.out.print("Elige una opción: ");
            String armaEleccion = scanner.nextLine();
            if (armaEleccion.equals("1")) {
                return new Humano(nombre, escopeta);
            } else {
                return new Humano(nombre, rifle);
            }
        } else if (eleccion.equals("2")) {
            System.out.println("Elige un tipo de magia:");
            System.out.println("1. Fuego");
            System.out.println("2. Tierra");
            System.out.println("3. Aire");
            System.out.println("4. Agua");
            System.out.print("Elige una opción: ");
            String magiaEleccion = scanner.nextLine();
            if (magiaEleccion.equals("1")) {
                return new Elfo(nombre, baculo, "fuego");
            } else if (magiaEleccion.equals("2")) {
                return new Elfo(nombre, baculo, "tierra");
            } else if (magiaEleccion.equals("3")) {
                return new Elfo(nombre, baculo, "aire");
            } else {
                return new Elfo(nombre, baculo, "agua");
            }
        } else if (eleccion.equals("3")) {
            System.out.println("Elige un arma:");
            System.out.println("1. Hacha");
            System.out.println("2. Martillo");
            System.out.print("Elige una opción: ");
            String armaEleccion = scanner.nextLine();
            if (armaEleccion.equals("1")) {
                return new Orco(nombre, hacha);
            } else {
                return new Orco(nombre, martillo);
            }
        } else if (eleccion.equals("4")) {
            System.out.println("Elige un arma:");
            System.out.println("1. Puños");
            System.out.println("2. Espada");
            System.out.print("Elige una opción: ");
            String armaEleccion = scanner.nextLine();
            if (armaEleccion.equals("1")) {
                return new Bestia(nombre, punos);
            } else {
                return new Bestia(nombre, espada);
            }
        } else {
            System.out.println("Opción no válida. Se te asignará un Humano con Rifle por defecto.");
            return new Humano(nombre, rifle);
        }
    }

    private static void gestionarTurno(Personaje atacante, Personaje defensor, Scanner scanner) {
        System.out.println("\n--- Turno de " + atacante.getNombre() + " ---");
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