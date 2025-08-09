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

public class Orco extends Personaje {

    public Orco(String nombre, Arma arma) {
        super(nombre, "Orco", 12, 15, 116, arma);
    }

    @Override
    public void atacar(Personaje enemigo) {
        Random random = new Random();
        int dmg = random.nextInt(
            arma.getdmgMaximo() - arma.getdmgMinimo() + 1
        ) + arma.getdmgMinimo();

        if (arma.getNombre().equalsIgnoreCase("Maza")) {
            dmg += (int)(dmg * 0.05); // +5%
        }

        enemigo.recibirdmg(dmg);
        System.out.println(nombre + " ataca con " + arma.getNombre() + " causando " + dmg + " de daño.");
    }

    @Override
    public void sanar() {
        int vidaMaxima = 140;
        int curacion = (vidaMaxima - vidaActual) / 2;
        vidaActual += curacion;

        if (vidaActual > vidaMaxima) {
            vidaActual = vidaMaxima;
        }

        System.out.println(nombre + " se cura " + curacion + " puntos de vida.");
    }
}
