<%@page import="PModelo.Paciente"%>
<%@page import="PModelo.CRUDPaciente"%>
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
        <link href="css/styles.css" rel="stylesheet">

        <title>Modificar Médico</title>
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
                            <a class="nav-link active" href="Acciones?action=pacientes">Pacientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Acciones?action=citas">Citas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
   
        <%  
            CRUDPaciente crud = new CRUDPaciente();
            
            int id = Integer.parseInt((String)request.getParameter("id"));
            Paciente paciente = crud.readById(id);
        %>
        <div class ="container">
            <div class="row head">
                <div class="col"><h3>Editar Paciente</h3></div>
            </div>
            <hr>
            
            <!-- form -->
            <form class="row g-3 needs-validation" novalidate>
                <div class="col-md-7">
                    <input type="hidden" name="pacienteId" value="<%= paciente.getId()%>">
                    <label class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" name="nombrePaciente" value="<%= paciente.getNombre() %>" placeholder="Nombres y Apellidos" required>
                    <div class="invalid-feedback">
                            Ingrese un nombre válido.
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Número de identificacion</label>
                    <input type="text" class="form-control" name="identificacionPaciente" placeholder="51955221" value="<%= paciente.getIdentificacion()%>" required>
                    <div class="invalid-feedback">
                            Ingrese una identificacion válida.
                    </div>
                </div>
                <div class="col-md-2">
                    <label class="form-label">Tipo identificación</label>
                    <select class="form-select" name="tipoIDPaciente" required>
                        <option selected disabled value="<%= paciente.getTipoID()%>">Selecciona...</option>
                        <option value="CC">CC</option>
                        <option value="CE">CE</option>
                        <option value="TI">TI</option>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese una tipo de identificacion válido.
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" name="fechaNacimientoPaciente" value="<%= paciente.getFechaNacimiento()%>" required>
                    <div class="invalid-feedback">
                        Ingrese una fecha de nacimiento< válida.
                    </div>
                </div>
                <div class="col-md-9">
                    <label class="form-label">EPS</label>
                    <input type="text" class="form-control" name="epsPaciente" placeholder="Nueva EPS, Colsanitas, ..." value="<%= paciente.getEps()%>" required>
                    <div class="invalid-feedback">
                            Ingrese una EPS válida.
                    </div>
                </div>
                <div class="col-md12">
                    <label class="form-label">Historia Clínica</label>
                    <textarea class="form-control" name="historiaClinicaPaciente" placeholder="ENFERMEDAD ACTUAL: Paciente, sexo femenino, 55 años de edad, con antecedentes de Hipertensión Arterial, desde 2012, tratada con Enalapril 10 mg/día sin dieta dash, ingresa en la guardia en martes 04/11/2014 a las 19:00 PM po (...)" required><%= paciente.getHistoriaClinica()%></textarea>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese historia clínica válida.
                    </div>
                </div>                
                <div class="col-12 text-center">
                    <input class="btn btn-primary" type="submit" name="action" value="Actualizar Paciente" text>
                </div>
            </form>
            <!-- end form -->
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="js/pac/updatePacJS.js"></script>
    </body>
</html>
