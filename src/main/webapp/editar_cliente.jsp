<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Clientes.Cliente" %>
<%
    Cliente c = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
    <!-- Bootstrap CSS 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow rounded">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">Editar Cliente</h4>
            </div>
            <div class="card-body">
                <form action="ServletCliente?accion=actualizar" method="post">
                    <input type="hidden" name="ClienteID" value="<%= c.getClienteID() %>">

                    <div class="mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="nombre" value="<%= c.getNombre() %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Dirección</label>
                        <input type="text" class="form-control" name="direccion" value="<%= c.getDireccion() %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Teléfono</label>
                        <input type="text" class="form-control" name="telefono" value="<%= c.getTelefono() %>" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" value="<%= c.getEmail() %>" required>
                    </div>

                    <div class="d-flex justify-content-between">
                        <a href="ServletCliente?accion=listar" class="btn btn-secondary">Cancelar</a>
                        <button type="submit" class="btn btn-success">Actualizar Cliente</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (opcional si usas componentes interactivos) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
