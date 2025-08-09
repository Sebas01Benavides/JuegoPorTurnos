package juego.personajes;

import juego.armitas.Arma; // Importa la clase Arma

/**
 * Clase abstracta base para todos los personajes del juego.
 * Define propiedades comunes y métodos abstractos que deben ser implementados por las subclases.
 */
public abstract class Personaje {
    protected String nombre;
    protected String tipo; // Ej. "Humano", "Elfo", "Orco", etc.
    protected int fuerza;
    protected int defensa;
    protected int vidaMaxima;
    protected int vidaActual;
    protected Arma arma; // Cada personaje tiene un arma

    /**
     * Constructor para crear un Personaje.
     * @param nombre El nombre del personaje.
     * @param tipo El tipo de personaje (ej. "Humano").
     * @param fuerza La fuerza base del personaje.
     * @param defensa La defensa base del personaje.
     * @param vidaMaxima La vida máxima del personaje.
     * @param arma El arma que el personaje usa.
     */
    public Personaje(String nombre, String tipo, int fuerza, int defensa, int vidaMaxima, Arma arma) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima; // Al iniciar, la vida actual es la máxima
        this.arma = arma;
    }

    // --- Getters ---
    /**
     * Obtiene el nombre del personaje.
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del personaje.
     * @return El tipo del personaje.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene la fuerza del personaje.
     * @return La fuerza del personaje.
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Obtiene la defensa del personaje.
     * @return La defensa del personaje.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Obtiene la vida actual del personaje.
     * @return La vida actual.
     */
    public int getVidaActual() {
        return vidaActual;
    }

    /**
     * Obtiene la vida máxima del personaje.
     * @return La vida máxima.
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * Obtiene el arma del personaje.
     * @return El objeto Arma del personaje.
     */
    public Arma getArma() {
        return arma;
    }

    // --- Métodos Abstractos ---
    /**
     * Método abstracto para que el personaje ataque a otro.
     * Cada subclase debe implementar su propia lógica de ataque.
     * @param enemigo El personaje al que se va a atacar.
     */
    public abstract void atacar(Personaje enemigo);
    
    /**
     * Método abstracto para que el personaje se cure.
     * Cada subclase debe implementar su propia lógica de curación.
     */
    public abstract void sanar();

    // --- Método Concreto ---
    /**
     * Lógica para que el personaje reciba daño.
     * Considera la defensa del personaje para reducir el daño.
     * @param dano El daño base que se intenta infligir.
     */
    public void recibirDmg(int dano) {
        // Ejemplo simple de reducción de daño por defensa
        int danoFinal = dano - (this.defensa / 5); 
        if (danoFinal < 0) {
            danoFinal = 0; // El daño no puede ser negativo
        }
        
        this.vidaActual -= danoFinal;
        if (this.vidaActual < 0) {
            this.vidaActual = 0; // La vida no puede ser menor a 0
        }
    }

    /**
     * Verifica si el personaje sigue vivo.
     * @return true si la vida actual es mayor que 0, false en caso contrario.
     */
    public boolean estaVivo() {
        return vidaActual > 0;
    }
}
