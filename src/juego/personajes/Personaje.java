/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.personajes;

/**
 * author Fabricio Castro V.
 **/

import juego.armitas.Arma;

public abstract class Personaje {
    protected String nombre;
    protected String raza;
    protected int fuerza;
    protected int energia;
    protected int vidaActual;
    protected Arma arma;

    public Personaje(String nombre, String raza, int fuerza, int energia, int vidaActual, Arma arma) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.energia = energia;
        this.vidaActual = vidaActual;
        this.arma = arma;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public Arma getArma() {
        return arma;
    }

    public boolean estaVivo() {
        return vidaActual > 0;
    }

    public void recibirdmg(int dmg) {
        vidaActual -= dmg;
        if (vidaActual < 0) vidaActual = 0;
    }

    public abstract void atacar(Personaje enemigo);

    public abstract void sanar();

    @Override
    public String toString() {
        return nombre + " (" + raza + ") - Vida: " + vidaActual + " - Arma: " + arma.getNombre();
    }
}
 