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

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
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
            throws ServletException, IOException {
        String Nombre = request.getParameter("Nombre");
        System.out.println(Nombre);
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

        Cliente cliente = new Cliente(ClienteID, Nombre, Direccion, Telefono, Email);
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.ActualizarCliente(cliente); // <- pasamos un objeto Cliente

        response.sendRedirect("ServletCliente?accion=listar");
    }

    public void mostrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.ListarClientes();
        request.setAttribute("clientes", lista);
        request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
    }

//    public void mostrarEstudiantes(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        ClienteDAO clienteDao = new ClienteDAO();
//        List<Cliente> Clientes = clienteDao.ListarClientes();
//        request.setAttribute("listadestudiantes", Clientes);
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//        mostrarEstudiantesModificar(request, response);

 //   }

    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int ClienteID = Integer.parseInt(request.getParameter("ClienteID"));
            System.out.println("Eliminando cliente con ID: " + ClienteID);

            ClienteDAO clienteDao = new ClienteDAO();
            clienteDao.eliminarDatosCliente(ClienteID);

            response.sendRedirect("ServletCliente?accion=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al eliminar: " + e.getMessage());
        }
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

        String accion = request.getParameter("accion");

        if ("eliminar".equals(accion)) {
            eliminarCliente(request, response); // Aquí ya se hace el redirect. No continuar.
            return; // IMPORTANTE: detener aquí
        }

        if ("listar".equals(accion)) {
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> lista = dao.ListarClientes();
            request.setAttribute("clientes", lista);
            request.getRequestDispatcher("lista_clientes.jsp").forward(request, response);
        }
        
        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("ClienteID"));
            Cliente cliente = new ClienteDAO().obtenerClientePorId(id); 
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("editar_cliente.jsp").forward(request, response);
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
        String accion = request.getParameter("accion");
        if ("guardar".equals(accion)) {
            guardarCliente(request, response);
        }
        if ("actualizar".equals(accion)) {
            int ClienteID = Integer.parseInt(request.getParameter("ClienteID"));
            String Nombre = request.getParameter("nombre");
            String Direccion = request.getParameter("direccion");
            String Telefono = request.getParameter("telefono");
            String Email = request.getParameter("email");

            Cliente c = new Cliente(ClienteID, Nombre, Direccion, Telefono, Email);
            new ClienteDAO().ActualizarCliente(c);

            response.sendRedirect("ServletCliente?accion=listar");
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
