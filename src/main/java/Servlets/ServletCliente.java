/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Clientes.Cliente;
import Clientes.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet(name = "ServletEstudiantes", urlPatterns = {"/ServletEstudiantes"})
public class ServletCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void guardarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String Nombre = request.getParameter("Nombre");
        String Direccion = request.getParameter("Direccion");
        String Telefono = request.getParameter("Telefono");
        String Email = request.getParameter("Email");
        ClienteDAO cliente = new ClienteDAO();
        cliente.InsertarCliente(Nombre, Direccion, Telefono, Email);
        //Redirigimos al JSP con mensaje de exito
        response.sendRedirect("GuardarCliente.jsp?mensaje=Ok");
    }

    public void ActualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ClienteID = Integer.parseInt(request.getParameter("ClienteID"));
        String Nombre = request.getParameter("Nombre");
        String Direccion = request.getParameter("Direccion");
        String Telefono = request.getParameter("Telefono");
        String Email = request.getParameter("Email");
        ClienteDAO estudianteDao = new ClienteDAO();
        estudianteDao.ActualizarCliente(ClienteID, Nombre, Direccion, Telefono, Email);
        response.sendRedirect("ServletEstudiantes?action=mostrar");
    }
     public void mostrarEstudiantesModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            ClienteDAO clienteDao = new ClienteDAO();
            List<Cliente> Clientes = clienteDao.ListarClientes();
            request.setAttribute("listadestudiantes",Clientes);
            request.getRequestDispatcher("ModificarClientes.jsp").forward(request, response);
     }
      public void mostrarEstudiantes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            ClienteDAO clienteDao = new ClienteDAO();
            List<Cliente> Clientes = clienteDao.ListarClientes();
            request.setAttribute("listadestudiantes",Clientes);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            mostrarEstudiantesModificar(request,response);
            
     }




    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("mostrar".equals(action)){
            // mostrar total de estudiantes
            mostrarEstudiantes(request,response);
        }else if("modificar".equals(action)){
            // Mostrar el formulario con los datos del estudiante teniendo como filtro el ID
            int ClienteID = Integer.parseInt(request.getParameter("ClienteID"));
            ClienteDAO ClienteDao = new ClienteDAO();
            Cliente cliente =ClienteDao.obtenerClientePorId(ClienteID);
            request.setAttribute("Cliente",cliente);
            request.getRequestDispatcher("ModificarCliente.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");
        if("guardar".equals(action)){
          guardarCliente(request,response);
        }else if("actualizar".equals(action)){
            ActualizarCliente(request,response); 
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}