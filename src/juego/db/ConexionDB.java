package juego.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author sebas
 */
public class ConexionDB {
    // Configuración de la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5432/bdjuegoporturnos"; //Estos tres campos se cambian en caso de querer iniciar la base de datos en otra computadora
    private static final String USUARIO = "postgres"; 
    private static final String PASSWORD = "admin";

    /**
     * Establece y devuelve una conexión a la base de datos.
     * @return Un objeto Connection si la conexión es exitosa, de lo contrario, null.
     */
    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el driver de PostgreSQL");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return conexion;
    }
}