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

public class Humano extends Personaje {

    public Humano(String nombre, Arma arma) {
        super(nombre, "Humano", 10, 10, 100, arma);
    }

    @Override
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        int dmg = random.nextInt(
            arma.getdmgMaximo() - arma.getdmgMinimo() + 1
        ) + arma.getdmgMinimo();

        if (arma.getNombre().equalsIgnoreCase("Escopeta")) {
            dmg += (int)(dmg * 0.02); // +2%
        }

        enemigo.recibirdmg(dmg);
        System.out.println(nombre + " ataca con " + arma.getNombre() + " causando " + dmg + " de daño.");
    }

    @Override
    public void sanar() {
        int vidaMaxima = 100;
        int curacion = (vidaMaxima - vidaActual) / 2;
        vidaActual += curacion;

        if (vidaActual > vidaMaxima) {
            vidaActual = vidaMaxima;
        }

        System.out.println(nombre + " se cura " + curacion + " puntos de vida.");
    }
}