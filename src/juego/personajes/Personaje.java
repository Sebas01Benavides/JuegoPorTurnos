package juego.personajes;

import juego.armitas.Arma; // Importa la clase Arma

/**
 * Clase abstracta base para todos los personajes del juego.
 * Define propiedades comunes y métodos abstractos que deben ser implementados por las subclases.
 */
public abstract class Personaje {
    protected String nombre;
    protected String tipo;
    protected int fuerza;
    protected int defensa;
    protected int vidaMaxima;
    protected int vidaActual;
    protected Arma arma;

    public Personaje(String nombre, String tipo, int fuerza, int defensa, int vidaMaxima, Arma arma) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.arma = arma;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    public int getVidaMaxima() {
        return vidaMaxima;
    }
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
    
    public int getVidaActual() {
        return vidaActual;
    }
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
    
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void recibirDmg(int dano) {
        int danoFinal = dano - (this.defensa / 5);
        if (danoFinal < 0) {
            danoFinal = 0;
        }
        this.vidaActual -= danoFinal;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public boolean estaVivo() {
        return vidaActual > 0;
    }
    
    public abstract void atacar(Personaje enemigo);
    public abstract void sanar();
}
