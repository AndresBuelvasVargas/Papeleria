/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author SAMI
 */
public class Conexion_Dao {
    //Declaración de las variables de conexion 
    private static final String URL="jdbc:mysql://localhost:3306/papeleriasammy";
    // Usuario de conexion a la base de datos
    private static final String USER ="root";
    // Clave de conexion a la base de datos en mysql
    private static final String PASS="";
    
    // Creación de una función conexion la cual nos va a permitir conectarnos a la base de datos
    public static Connection ObtenerConexion(){
        // Declaramos conexion el valor
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
    
        // Nuevo método para cerrar la conexión
    public static void CerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    // usamos una funcion que nos permita probar por consola si la conexion a la base de datos esta funciona
    public static void main(String[] args) {
    try {
        Connection conn = Conexion_Dao.ObtenerConexion();
        if (conn != null) {
            System.out.println(" Conexion exitosa a la base de datos.");
            conn.close();
        } else {
            System.out.println(" No se pudo establecer conexión.");
        }
    } catch (SQLException e) {
        System.out.println(" Error al conectar: " + e.getMessage());
        e.printStackTrace();
    }
}

}