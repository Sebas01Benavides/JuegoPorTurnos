package juego.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author sebas
 */
public class ControladorDeVictorias {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/tu_base_de_datos";
        String usuario = "admin";
        String password = "admin";
        return DriverManager.getConnection(url, usuario, password);
    }
    
    public static void guardarVictoria(String nombreJugador) {
        String sql = "INSERT INTO victorias (nombre_jugador) VALUES (?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreJugador);
            pstmt.executeUpdate();
            
            System.out.println("Se ha registrado la victoria de " + nombreJugador);

        } catch (SQLException e) {
            System.err.println("Error al guardar la victoria en la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
