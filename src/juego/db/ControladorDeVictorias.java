package juego.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author sebas
 */
public class ControladorDeVictorias {

    public static Connection getConnection() throws SQLException {
        // Debes cambiar estos valores por los tuyos
        String url = "jdbc:postgresql://localhost:5432/bdjuegoportunos";
        String usuario = "admin";
        String password = "admin";
        return DriverManager.getConnection(url, usuario, password);
    }
    
    public static void actualizarPartida(String nombreJugador, boolean haGanado) {
        String selectSql = "SELECT victorias, derrotas FROM jugador WHERE nombre_jugador = ?";
        String insertSql = "INSERT INTO jugador (nombre_jugador, victorias, derrotas) VALUES (?, ?, ?)";
        String updateSql = "UPDATE jugador SET victorias = ?, derrotas = ? WHERE nombre_jugador = ?";

        try (Connection conn = getConnection()) {
            
            // Busca si el jugador ya existe primero
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setString(1, nombreJugador);
            ResultSet rs = selectStmt.executeQuery();

            int victorias = 0;
            int derrotas = 0;

            if (rs.next()) {
                // El jugador existe, obtenemos sus estadísticas
                victorias = rs.getInt("victorias");
                derrotas = rs.getInt("derrotas");
                
                if (haGanado) {
                    victorias++;
                } else {
                    derrotas++;
                }

                // Actualiza las estadísticas
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, victorias);
                updateStmt.setInt(2, derrotas);
                updateStmt.setString(3, nombreJugador);
                updateStmt.executeUpdate();
                System.out.println("Se ha actualizado la partida de " + nombreJugador);

            } else {
                // Si el jugador no existe, entonces se crea
                if (haGanado) {
                    victorias = 1;
                } else {
                    derrotas = 1;
                }

                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, nombreJugador);
                insertStmt.setInt(2, victorias);
                insertStmt.setInt(3, derrotas);
                insertStmt.executeUpdate();
                System.out.println("Se ha registrado a " + nombreJugador + " con una nueva partida.");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar la partida en la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
