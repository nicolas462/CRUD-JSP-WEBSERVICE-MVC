<%@page import="java.util.List"%>
<%@page import="PModelo.CRUDPaciente"%>
<%@page import="PModelo.Paciente"%>
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

      <title>Pacientes</title>
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
            int flag = 0;
            int pagina = 0;
            try 
            {
                flag = Integer.parseInt((String) request.getParameter("flag"));
            } catch (Exception ex) {
            }
            try 
            {
                pagina = Integer.parseInt((String) request.getParameter("page"));
            } catch (Exception ex) {}
            
            String column = request.getParameter("column");
            String param = request.getParameter("param");            
        %>
        <div class ="container <%= flag %>">
            <div class="row head">
                <div class="col"><h3>Pacientes Registrados</h3></div>
                <div class="col text-end"><a class="btn btn-primary btn-lg" href="Acciones?action=anadirPaciente">Añadir Paciente</a></div>
            </div>
            <hr>
            <!-- search button -->
            <div class="row">
                <div class="col-md">
                    <div class="input-group mb-3">
                      <input class="form-control me-2" type="search" id="identificacionParam" placeholder="Buscar por identificacion" aria-label="Search">
                      <a class="btn btn-outline-primary" id="searchByIdentificacion">Buscar</a> 
                    </div>
                </div>
                <div class="col-md">
                    <div class="input-group mb-3">
                      <input class="form-control me-2" type="search" id="nombreParam" placeholder="Buscar por nombre" aria-label="Search">
                      <a class="btn btn-outline-primary" id="searchByNombre">Buscar</a>
                    </div>
                </div>
                <div class="col-md">
                    <div class="input-group mb-3">
                      <input class="form-control me-2" type="search" id="epsParam" placeholder="Buscar por EPS" aria-label="Search">
                      <a class="btn btn-outline-primary" id="searchByEps">Buscar</a>
                    </div>
                </div>    
            </div>
            <!-- end search button -->             
            <div class="table-responsive">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Nombre</th>
                  <th scope="col">Identificación</th>
                  <th scope="col">TipoID</th>
                  <th scope="col">Fecha Nacimiento</th>
                  <th scope="col">EPS</th>          
                </tr>
              </thead>
              <tbody>
                <% 
                    CRUDPaciente p = new CRUDPaciente();
                    List <Paciente> list = p.readByParam(column, param,pagina*10,(pagina*10)+10);
                    for (int i = 0; i < list.size(); i++)
                    {
                %>
                <tr>
                    <th scope="row"><%= list.get(i).getId()%></th>
                    <td><%= list.get(i).getNombre()%></td>
                    <td><%= list.get(i).getIdentificacion()%></td>
                    <td><%= list.get(i).getTipoID()%></td>
                    <td><%= list.get(i).getFechaNacimiento()%></td>
                    <td><%= list.get(i).getEps()%></td>  
                    <td><a class="btn btn-warning" href="Acciones?action=updatePaciente&id=<%= list.get(i).getId()%>">Editar</a></td>
                    <td><a class="btn btn-danger" onclick="getIdPaciente(event)" id="<%= list.get(i).getId()%>" data-bs-toggle="modal" data-bs-target="#deleteModal">Eliminar</a></td>
                </tr>
                <tr>
                <td colspan="6">
              <div class="accordion" id="accordion<%= list.get(i).getId()%>">
                  <div class="accordion-item">
                      <h2 class="accordion-header" id="heading<%= list.get(i).getId()%>">
                          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%= list.get(i).getId()%>" aria-expanded="false" aria-controls="collapse<%= list.get(i).getId()%>">
                              Historia clínica
                          </button>
                      </h2>
                      <div id="collapse<%= list.get(i).getId()%>" class="accordion-collapse collapse" aria-labelledby="heading<%= list.get(i).getId()%>" data-bs-parent="#accordion<%= list.get(i).getId()%>">
                          <div class="accordion-body">
                              <%= list.get(i).getHistoriaClinica()%>
                          </div>
                      </div>
                  </div>
              </div>
              </td>
            </tr>
               <% } %>
              </tbody>
            </table>
            </div>
            <!-- pagination -->
            <nav aria-label="navPagination">
              <ul class="pagination">
                <li class="page-item disabled">
                  <a class="page-link" href="Acciones?action=pacientes&page=<%= pagina - 1%>" tabindex="-1" id="prevPage" aria-disabled="true">Anterior</a>
                </li>
                <li class="page-item active"><a class="page-link" id="firstPage-btn" href="Acciones?action=pacientes&page=<%= (+pagina != 0) ? (pagina - 1) : pagina%>">1</a></li>
                <li class="page-item" aria-current="page">
                  <a class="page-link" id="secondPage-btn" href="Acciones?action=pacientes&page=<%= (+pagina != 0) ? pagina : (pagina + 1)%>">2</a>
                </li>
                <li class="page-item"><a id="thirdPage-btn" class="page-link" href="Acciones?action=pacientes&page=<%= (+pagina != 0) ? (pagina + 1) : (pagina + 2)%>">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="Acciones?action=pacientes&page=<%= pagina + 1%>" id="nextPage" >Siguiente</a>
                </li>
              </ul>
            </nav>
            <!-- end pagination -->              
              <!-- success modal -->
              <div class="modal fade" id="successModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="successModalLabel">Cambios almacenados</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              Los cambios se han guardado exitosamente.
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-success" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end success modal -->
              <!-- fail modal -->
              <div class="modal fade" id="failModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="failModalLabel">Algo salió mal</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              Ocurrió un error en el proceso. Intente nuevamente.
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end fail modal -->
              <!-- delete modal -->
              <div class="modal fade" id="deleteModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="deleteModal">Borrar registro</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              ¿Estás seguro que deseas borrar el registro?
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                              <button type="button" id="deleteModalbtn" class="btn btn-danger" data-bs-dismiss="modal">Eliminar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end delete modal -->
              <!-- exists modal -->
              <div class="modal fade" id="existsModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="existsModal">Registro encontrado</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              Ya se encuentra registrado un paciente con la identificación y el tipo de identificación seleccionados.
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end exists modal -->               
        </div>
        <input type="hidden" id="page" value="<%= pagina %>">
        <input type="hidden" id="querySize" value="<%= list.size() %>">              
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="js/pac/pacientesJS.js"></script>
    </body>
</html>
