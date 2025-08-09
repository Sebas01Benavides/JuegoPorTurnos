package juego.armitas;

/**
 * Clase que representa un arma en el juego.
 * @author Fabricio Castro V.
 **/
public class Arma {
    private String nombre;
    private String tipo;      // Ej. "Melee", "Rango", "Mágica"
    private int dmgMinimo;    // Daño mínimo que puede hacer el arma
    private int dmgMaximo;    // Daño máximo que puede hacer el arma
    private double modificador; // Porcentaje extra de daño (ej. 0.02 para +2%)

    /**
     * Constructor para crear una nueva instancia de Arma.
     * @param nombre El nombre del arma.
     * @param tipo El tipo de arma (ej. "Melee").
     * @param dmgMinimo El daño mínimo base del arma.
     * @param dmgMaximo El daño máximo base del arma.
     * @param modificador Un modificador de daño porcentual.
     */
    public Arma(String nombre, String tipo, int dmgMinimo, int dmgMaximo, double modificador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dmgMinimo = dmgMinimo;
        this.dmgMaximo = dmgMaximo;
        this.modificador = modificador;
    }

    /**
     * Obtiene el nombre del arma.
     * @return El nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del arma.
     * @return El tipo del arma.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el daño mínimo del arma.
     * @return El daño mínimo.
     */
    public int getdmgMinimo() {
        return dmgMinimo;
    }

    /**
     * Obtiene el daño máximo del arma.
     * @return El daño máximo.
     */
    public int getdmgMaximo() {
        return dmgMaximo;
    }

    /**
     * Obtiene el modificador de daño del arma.
     * @return El modificador de daño.
     */
    public double getModificador() {
        return modificador;
    }
}
