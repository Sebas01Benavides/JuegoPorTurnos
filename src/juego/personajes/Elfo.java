/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.personajes;

/*
*author Fabricio castro V.
*/

import juego.armitas.Arma;
import java.util.Random;

public class Elfo extends Personaje {

    private String tipoMagia;

    public Elfo(String nombre, Arma arma, String tipoMagia) {
        super(nombre, "Elfo", 11, 12, (tipoMagia.equalsIgnoreCase("agua") ? 115 : 100), arma);
        this.tipoMagia = tipoMagia;
    }

    public String getTipoMagia() {
        return tipoMagia;
    }
    public void setTipoMagia(String tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    @Override
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        int dano = random.nextInt(5) + 1;

        if (this.tipoMagia.equalsIgnoreCase("fuego")) {
            dano += (int) (dano * 0.10);
        }
        
        enemigo.recibirDmg(dano);
        System.out.println(this.nombre + " lanza magia de " + this.tipoMagia + " a " + enemigo.getNombre() + " causando " + dano + " de daño.");
    }

    @Override
    public void sanar() {
        int curacion;
        if (this.tipoMagia.equalsIgnoreCase("agua")) {
            curacion = (int) (this.vidaMaxima * 0.90);
        } else {
            curacion = (int) (this.vidaMaxima * 0.75);
        }

        this.vidaActual += curacion;
        if (this.vidaActual > this.vidaMaxima) {
            this.vidaActual = this.vidaMaxima;
        }
        System.out.println(this.nombre + " lanza un hechizo de sanación y recupera " + curacion + " puntos de vida.");
    }
}