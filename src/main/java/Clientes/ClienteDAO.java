/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import ConexionBD.Conexion_Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMI
 */
public class ClienteDAO {
    // creamos una función la cual nos permite insertar nuevos registros de estudiante
    public void InsertarCliente(String Nombre, String Direccion, String Telefono, String Email){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
           // consulta inserccion de registro en la base de datos
           conn = Conexion_Dao.ObtenerConexion();
           String sql = "INSERT INTO estudiantes(Nombre,Direccion,Telefono,Email) VALUES(?,?,?,?)";
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, Nombre);
           stmt.setString(2, Direccion);
           stmt.setString(3, Telefono);
           stmt.setString(4, Email);
           stmt.executeUpdate();
           
          }catch(Exception e){
              System.out.println("Error al insertar estudiante"+e.getMessage());
              e.printStackTrace();
          }finally{
                   Conexion_Dao.CerrarConexion(conn);
                  }
        
        
    }
    // creamos una función tipo publica la cual nos permite actualizar los datos de los estudiantes
    public void ActualizarCliente(int ClienteID, String Nombre, String Direccion, String Telefono, String Email){
     Connection conn = null;
     PreparedStatement stmt = null;
     try{
         // para conectarnos a nuestra base de datos con la función obtenerConexion
        conn = Conexion_Dao.ObtenerConexion();
        // Realizamos la consulta a nuestra base de datos
        String sql ="update Cliente set Nombre =?, Direccion=?, Telefono=?, Email=? WHERE ClienteID=?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, Nombre);
        stmt.setString(2, Direccion);
        stmt.setString(3, Telefono);
        stmt.setString(4, Email);
        stmt.setInt(5, ClienteID);
        stmt.executeUpdate();
        
     }catch(Exception e){
          System.out.println("Error al actualizar registro de estudiante"+e.getMessage());
              e.printStackTrace();
     }finally{
                   Conexion_Dao.CerrarConexion(conn);
                  }
    }
    // Listar Estudiantes
    public List<Cliente> ListarClientes(){
    List<Cliente> Cliente = new ArrayList<>();
    Connection conn= null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try{
        conn = Conexion_Dao.ObtenerConexion();
        String sql ="SELECT * FROM estudiantes;";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        while(rs.next()){
        Cliente Client = new Cliente();
        Client.setClienteID(rs.getInt("ClienteID"));
        Client.setNombre(rs.getString("Nombre"));
        Client.setDireccion(rs.getString("Direccion"));
        Client.setTelefono(rs.getString("Telefono"));
        Client.setEmail(rs.getString("Email"));
        Cliente.add(Client);
        }
    }catch(Exception e){
      e.printStackTrace();
    }finally{
        Conexion_Dao.CerrarConexion(conn);
        
    }
        return Cliente;
        
    }
// Funcion para obtenerEstudiantesPorId el cual nos permite actualizar los datos de los estudiantes 
  public Cliente obtenerClientePorId(int id){
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Cliente Client = null;

    try{
        // Conexión a la base de datos
        conn = Conexion_Dao.ObtenerConexion();
        String sql = "SELECT * FROM Cliente WHERE ClienteID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if(rs.next()){
            Client = new Cliente();
            Client.setClienteID(rs.getInt("ClienteID"));
            Client.setNombre(rs.getString("Nombre"));
            Client.setDireccion(rs.getString("Direccion"));
            Client.setTelefono(rs.getString("Telefono"));
            Client.setDireccion(rs.getString("Email"));
        }

    }catch(Exception e){
        System.out.println("Error al obtener estudiante por ID: " + e.getMessage());
        e.printStackTrace();
    }finally{
        Conexion_Dao.CerrarConexion(conn);
    }

    return Client;
}
 /*
    Se crea una función para contar el numero de estudiantes e implementar en dashboard principal y muestre en una card el numerode estudiantes
  */
  
  public int contarCliente(){
   int total = 0;
   Connection conn = null;
   PreparedStatement stmt = null;
   ResultSet rs = null;
   try{
       conn = Conexion_Dao.ObtenerConexion();
       String sql = "SELECT COUNT(*) FROM Cliente;";
       stmt = conn.prepareStatement(sql);
       rs = stmt.executeQuery();
       if(rs.next()){
           total = rs.getInt(1);
       }
   }catch(Exception e ){
       System.out.println("Error al contar estudiantes" +e.getMessage());
   }finally{
     Conexion_Dao.CerrarConexion(conn);
   }
   return total;
  }
  public void eliminarDatosCliente(int id){
   Connection conn = null;
   PreparedStatement stmt = null;
   try{ 
       conn = Conexion_Dao.ObtenerConexion();
       String sql = "DELETE FROM Cliente WHERE ClienteID=?";
       stmt = conn.prepareStatement(sql);
       stmt.setInt(1,id);
       stmt.executeUpdate();
      
   }catch(Exception e){
       e.printStackTrace();
   }finally{
       Conexion_Dao.CerrarConexion(conn);
       try{
           if(stmt !=null) stmt.close();
           
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
  }
}
