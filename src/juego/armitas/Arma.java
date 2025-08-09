/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego.armitas;

/**
*author Fabricio Castro V.
**/

public class Arma {
    private String nombre;
    private String tipo;
    private int dmgMinimo;
    private int dmgMaximo;
    private double modificador; // porcentaje extra de daño

    public Arma(String nombre, String tipo, int dmgMinimo, int dmgMaximo, double modificador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dmgMinimo = dmgMinimo;
        this.dmgMaximo = dmgMaximo;
        this.modificador = modificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getdmgMinimo() {
        return dmgMinimo;
    }

    public int getdmgMaximo() {
        return dmgMaximo;
    }

    public double getModificador() {
        return modificador;
    }
}
