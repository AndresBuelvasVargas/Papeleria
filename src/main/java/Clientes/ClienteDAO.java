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
           String sql = "INSERT INTO Cliente(Nombre,Direccion,Telefono,Email) VALUES(?,?,?,?)";
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, Nombre);
           stmt.setString(2, Direccion);
           stmt.setString(3, Telefono);
           stmt.setString(4, Email);
           stmt.executeUpdate();
           
          }catch(Exception e){
              System.out.println("Error al insertar cliente"+e.getMessage());
              e.printStackTrace();
          }finally{
                   Conexion_Dao.CerrarConexion(conn);
                  }
        
        
    }
    // creamos una función tipo publica la cual nos permite actualizar los datos de los clientes
    public void ActualizarCliente(Cliente cliente) {
        try (Connection conn = Conexion_Dao.ObtenerConexion()) {
            String sql = "UPDATE Cliente SET Nombre=?, Direccion=?, Telefono=?, Email=? WHERE ClienteID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getClienteID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Listar Clientes

    public List<Cliente> ListarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";

        try {
            Connection con = Conexion_Dao.ObtenerConexion(); // usa tu clase de conexión
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setClienteID(rs.getInt("ClienteID"));
                c.setNombre(rs.getString("Nombre"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
                c.setEmail(rs.getString("Email"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
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
            Client.setEmail(rs.getString("Email"));
        }

    }catch(Exception e){
        System.out.println("Error al obtener Cliente por ID: " + e.getMessage());
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
       System.out.println("Error al contar Clientes" +e.getMessage());
   }finally{
     Conexion_Dao.CerrarConexion(conn);
   }
   return total;
  }
  public void eliminarDatosCliente(int ID){
   Connection conn = null;
   PreparedStatement stmt = null;
   try{ 
       conn = Conexion_Dao.ObtenerConexion();
       String sql = "DELETE FROM Cliente WHERE ClienteID=?";
       stmt = conn.prepareStatement(sql);
       stmt.setInt(1,ID);
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
