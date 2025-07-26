/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

/**
 *
 * @author SAMI
 */
public class Cliente {
    //declaramos las variables como private para proteger los datos y garantizar el principio de encapsulamiento
    private int ClienteID;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String Email;

    // constructor vacio de utilidad para cuando aun no tenemos los datos
    public Cliente()
    {}
    //constructor completo que nos permite crear un estudiante con todos sus datos de una sola vez
    public Cliente(int ClienteID,String Nombre, String Direccion, String Telefono,String Email)
    {
     this.ClienteID=ClienteID;
     this.Nombre=Nombre;
     this.Direccion=Direccion;
     this.Telefono=Telefono;
     this.Email=Email;
    
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int ClienteID) {
        this.ClienteID = ClienteID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}