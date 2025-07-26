<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5" style="max-width: 500px;">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h4 class="mb-0">Registrar Nuevo Cliente</h4>
        </div>
        <div class="card-body">
            <form action="ServletCliente?accion=guardar" method="post">
                <div class="mb-3">
                    <label for="Nombre" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" name="Nombre" id="Nombre" required>
                </div>

                <div class="mb-3">
                    <label for="Direccion" class="form-label">Dirección:</label>
                    <input type="text" class="form-control" name="Direccion" id="Direccion" required>
                </div>

                <div class="mb-3">
                    <label for="Telefono" class="form-label">Teléfono:</label>
                    <input type="text" class="form-control" name="Telefono" id="Telefono" required>
                </div>

                <div class="mb-3">
                    <label for="Email" class="form-label">Email:</label>
                    <input type="email" class="form-control" name="Email" id="Email" required>
                </div>

                <button type="submit" class="btn btn-success w-100">Guardar Cliente</button>
            </form>

            <a href="ServletCliente?accion=listar" class="btn btn-secondary w-100 mt-3">Regresar</a>

            <%
                String mensaje = request.getParameter("mensaje");
                if ("Ok".equals(mensaje)) {
            %>
                <div class="alert alert-success text-center mt-3" role="alert">
                    Cliente guardado exitosamente.
                </div>
            <%
                }
            %>
        </div>
    </div>
</div>

<!-- Bootstrap JS (opcional si usas componentes dinámicos) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>