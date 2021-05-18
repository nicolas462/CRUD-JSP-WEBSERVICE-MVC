<%@page import="PModelo.Paciente"%>
<%@page import="PModelo.Medico"%>
<%@page import="PModelo.CRUDPaciente"%>
<%@page import="PModelo.CRUDMedico"%>
<%@page import="java.util.List"%>
<%@page import="PModelo.Cita"%>
<%@page import="PModelo.CRUDCita"%>
<%@page import="java.text.DecimalFormat"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <link href="/Quileia/css/styles.css" rel="stylesheet">

        <title>Ingresar Paciente</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
            <div class="container-fluid">
                <a class="navbar-brand" href="/Quileia/index.jsp">
                        <img src="https://i.pinimg.com/originals/4f/60/30/4f60305f48b01e05db6b53083abf71dd.png"  width="70" height="64">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/Quileia/index.jsp">Médicos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Acciones?action=pacientes">Pacientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="Acciones?action=citas">Citas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class ="container">
            <div class="row head">
                <div class="col"><h3>Nueva Cita</h3></div>
            </div>
            <hr>
            <!-- form -->
            <form class="row g-3 needs-validation" novalidate>
            <div class="col-md-2">
                <label class="form-label disabled">Fecha Solicitada</label>
                <input type="date" class="form-control" name="fechaSolicitadaCita" value=""  readonly="readonly">
            </div>
            <div class="col-md-10"></div>
                <div class="col-md-2">
                    <label class="form-label">Tipo identificación</label>
                    <select class="form-select" name="tipoIDPacienteCita" required>
                        <option selected disabled value="">Selecciona...</option>
                        <option value="CC">CC</option>
                        <option value="CE">CE</option>
                        <option value="TI">TI</option>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese una tipo de identificacion válido.
                    </div>
                </div>
                <div class="col-6">
                    <label class="form-label">Documento paciente</label>
                    <input type="text" class="form-control" name="documentoPacienteCita" value="" required>
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <hr>
                </div>
                <div class="col-md-4"></div>
                <!-- Médico -->
                <div class="col-md-12 text-start">
                    <Strong>Datos Médico</Strong>
                </div>
                <div class="col-md-2">
                    <label class="form-label">Tipo identificación</label>
                    <select class="form-select" name="tipoIDMedicoCita" required>
                        <option selected disabled value="">Selecciona...</option>
                        <option value="CC">CC</option>
                        <option value="CE">CE</option>
                        <option value="TI">TI</option>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese una tipo de identificación válida.
                    </div>
                </div>
                <div class="col-6">
                    <label class="form-label">Documento médico</label>
                    <input type="text" class="form-control" name="documentoMedicoCita" value="" required>
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-5"></div>
                <div class="col-md-2">
                    <label class="form-label">Fecha Asignada</label>
                    <input type="date" class="form-control" name="fechaAsignadaCita" value="" required>
                </div>
                <div class="col-md-5"></div>                
                <div class="col-md-4"></div>                
                <div class="col-md-4">
                    <label class="form-label">Hora Atención</label>
                    <div class="input-group">
                        <select class="scheduleSelect form-select form-label" name="horaAsignadaCita" required>
                            <option selected disabled value="">...</option>
                        </select>
                        <label style="margin:    0 10px 0 10px">:</label>
                        <select class="scheduleSelect form-select form-label" name="minutoAsignadoCita" required>
                            <option selected disabled value="">...</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-4"></div>
                <div class="col-12 text-center">
                    <input class="btn btn-success" type="submit" name="action" value="Asignar Cita" text>
                </div>                                
            </form>
            <!-- end form -->
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="js/cita/citasJS.js"></script>
    </body>
</html>
