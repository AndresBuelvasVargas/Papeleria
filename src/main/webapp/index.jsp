<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Papeleria Sammy </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
        <link rel="stylesheet" href="Public/CSS/estilos.css">
    </head>
    <body>
        <div class="container py-5">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card text-center">
                        <img src="Public/Imagenes/s.jpg" class="img-fluid mx-auto d-block" style="max-height: 250px; object-fit: contain;" alt="Papelería">
                        <div class="card-body">
                            <h2><b>SISTEMA DE INFORMACIÓN DE PAPELERÍA</b></h2>
                            <hr>
                            <div class="d-grid gap-2">
                                <a href="ServletCliente?accion=listar" class="btn btn-custom btn-estudiante">Gestión de Clientes</a>
                                <a href="#" class="btn btn-custom btn-materia">Gestión de Productos</a>
                                <a href="#" class="btn btn-custom btn-docente">Gestión de Proveedores</a>
                                <a href="#" class="btn btn-custom btn-programa">Gestión de Ventas</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>