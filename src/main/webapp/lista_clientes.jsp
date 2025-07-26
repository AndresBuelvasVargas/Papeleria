<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Clientes.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Clientes</title>
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <!-- Estilos propios -->
        <link rel="stylesheet" href="Public/CSS/estilos.css">
    </head>
    <body>



        <div class="container mt-5">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2 class="text-primary fw-bold">📋 Clientes</h2>
                <a href="GuardarCliente.jsp" class="btn btn-success shadow-sm">
                    ➕ Añadir nuevo cliente
                </a>
            </div>

            <table class="table table-bordered table-striped text-center">
                <thead class="table-dark">
                    <tr>
                        <%-- <th>ID</th> --%>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Modificaciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                        if (clientes != null && !clientes.isEmpty()) {
                            for (Cliente c : clientes) {
                    %>
                    <tr>
                        <%-- <td><%= c.getClienteID()%></td> --%>
                        <td><%= c.getNombre()%></td>
                        <td><%= c.getDireccion()%></td>
                        <td><%= c.getTelefono()%></td>
                        <td><%= c.getEmail()%></td>
                        <td>
                            <a href="ServletCliente?accion=editar&ClienteID=<%= c.getClienteID()%>" class="btn btn-sm btn-warning">✏️ Editar</a>
                            <a href="ServletCliente?accion=eliminar&ClienteID=<%= c.getClienteID()%>"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('¿Deseas eliminar este cliente?');">
                                🗑️ Eliminar
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">No hay clientes registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón de Volver al Inicio -->
            <div class="mt-4 text-start">
                <a href="index.jsp" class="btn btn-secondary">
                    🔙 Volver al inicio
                </a>
            </div>
        </div>
    </body>
</html>
