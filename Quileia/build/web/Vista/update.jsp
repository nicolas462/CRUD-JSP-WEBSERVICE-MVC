<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="PModelo.Medico"%>
<%@page import="PModelo.CRUDMedico"%>
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
                            <a class="nav-link active" aria-current="page" href="/Quileia/index.jsp">Médicos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Acciones?action=pacientes">Pacientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Acciones?action=citas">Citas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
   
        <%  
            CRUDMedico m = new CRUDMedico();
            
            int id = Integer.parseInt((String)request.getParameter("id"));
            Medico med = m.readById(id);
        %>
        <div class ="container">
            <div class="row head">
                <div class="col"><h3>Editar Registrados</h3></div>
            </div>
            <hr>
            
            <!-- form -->
            <form class="row g-3 needs-validation" novalidate>
                <div class="col-md-7">
                    <input type="hidden" name="medicoId" value="<%= med.getId()%>">
                    <label class="form-label">Nombre Completo</label>
                    <input type="text" class="form-control" name="nombreMedico" value="<%= med.getNombre() %>" placeholder="Nombres y Apellidos" required>
                    <div class="invalid-feedback">
                            Ingrese un nombre válido.
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Número de identificacion</label>
                    <input type="text" class="form-control" name="identificacionMedico" placeholder="51955221" value="<%= med.getIdentificacion()%>" required>
                    <div class="invalid-feedback">
                            Ingrese una identificacion válida.
                    </div>
                </div>
                <div class="col-md-2">
                    <label class="form-label">Tipo identificación</label>
                    <select class="form-select" name="tipoIDMedico" required>
                        <option selected disabled value="<%= med.getTipoID()%>">Selecciona...</option>
                        <option value="CC">CC</option>
                        <option value="CE">CE</option>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese una tipo de identificacion válido.
                    </div>
                </div>                
                    <div class="col-md-6">
                    <label class="form-label">Especialización</label>
                    <input type="text" class="form-control" name="especializacionMedico" value="<%= med.getEspecialidad()%>" placeholder="Cirugía, Dermatología, ..." required>
                    <div class="invalid-feedback">
                            Ingrese una especialización válida.
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Número Tarjeta Profesional</label>
                    <input type="text" class="form-control" name="tarjetaProfesionalMedico" placeholder="218066-E" value="<%= med.getNumTarjetaProf()%>" required>
                    <div class="invalid-feedback">
                            Ingrese una tarjeta profesional válida.
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Años de experiencia</label>
                    <input type="text" class="form-control" name="anosExpMedico" placeholder="1.2" value="<%= String.format(Locale.US,"%.1f",med.getAnosExp()) %>" required>
                    </select>
                    <div class="invalid-feedback">
                        Ingrese años válidos.
                    </div>
                </div>
                <div class="col-md"></div>
                <div class="col-md-3">
                    <label class="form-label">Hora Inicio Atención</label>
                    <div class="input-group">
                        <select class="scheduleSelect form-select form-label" name="horaInicioMedico" required>
                            <option selected disabled value="<%= med.getHoraInicio().split(":")[0] %>">...</option>
                        </select>
                        <label style="margin:    0 10px 0 10px">:</label>
                        <select class="scheduleSelect form-select form-label" name="minutosInicioMedico" required>
                            <option selected disabled value="<%= med.getHoraInicio().split(":")[1] %>">...</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Hora Fin Atención</label>
                    <div class="input-group">
                        <select class="scheduleSelect form-select form-label" name="horaFinMedico" required>
                            <option selected disabled value="<%= med.getHoraFin().split(":")[0] %>">...</option>
                        </select>
                        <label style="margin:    0 10px 0 10px">:</label>
                        <select class="scheduleSelect form-select form-label" name="minutosFinMedico" required>
                            <option selected disabled value="<%= med.getHoraFin().split(":")[1] %>">...</option>
                        </select>
                    </div>
                </div>
                <div class="col-md"></div>
                
                <div class="col-12 text-center">
                    <input class="btn btn-primary" type="submit" name="action" value="Guardar Cambios" text>
                </div>
            </form>
            <!-- end form -->
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
