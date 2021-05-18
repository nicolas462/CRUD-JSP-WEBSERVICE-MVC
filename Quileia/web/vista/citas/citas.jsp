<%@page import="java.util.List"%>
<%@page import="PModelo.CRUDCita"%>
<%@page import="PModelo.Cita"%>
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
                            <a class="nav-link" href="Acciones?action=pacientes">Pacientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="Acciones?action=citas">Citas</a>
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
            } catch (Exception ex) {}
            try 
            {
                pagina = Integer.parseInt((String) request.getParameter("page"));
            } catch (Exception ex) {} 
        %>
        <div class ="container <%= flag %>">
            <div class="row head">
                <div class="col"><h3>Citas Registradas</h3></div>
                <div class="col text-end"><a class="btn btn-primary btn-lg" href="Acciones?action=anadirCita">Nueva Cita</a></div>
            </div>
            <hr>
        <div class="table-responsive">             
            <table class="table table-hover table-responsive">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Fecha Solicitada</th>
                  <th scope="col">Paciente</th>
                  <th scope="col">Médico</th>
                  <th scope="col">Fecha Asignada</th>
                  <th scope="col">Hora Asignada</th>
                </tr>
              </thead>             
              <tbody>
                <% 
                    CRUDCita c = new CRUDCita();
                    List <Cita> list = c.readByLimit(pagina*10,(pagina*10)+10);
                    for (int i = 0; i < list.size(); i++)
                    {
                %>
                <tr>
                    <th scope="row"><%= list.get(i).getId()%></th>
                    <td><%= list.get(i).getFecha_solicitada()%></td>
                    <td>
                        <input type="hidden" value="<%= list.get(i).getIdPaciente()%>">
                        <%= list.get(i).getInfPaciente().split(",")[0]%>
                        <br>
                        <%= list.get(i).getInfPaciente().split(",")[2]%>
                        - 
                        <%= list.get(i).getInfPaciente().split(",")[1]%>
                    </td>
                    <td>
                        <input type="hidden" value="<%= list.get(i).getIdMedico()%>">
                        <%= list.get(i).getInfMedico().split(",")[0]%>
                        <br>
                        <%= list.get(i).getInfMedico().split(",")[2]%>
                        - 
                        <%= list.get(i).getInfMedico().split(",")[1]%>
                    </td>
                    <td><%= list.get(i).getFecha_asignada() %></td> 
                    <td><%= list.get(i).getHora_asignada() %></td>
                </tr>
               <% } %>
              </tbody>
            </table>
        </div>
            <!-- pagination -->
            <nav aria-label="navPagination">
              <ul class="pagination">
                <li class="page-item disabled">
                  <a class="page-link" href="Acciones?action=citas&page=<%= pagina - 1%>" tabindex="-1" id="prevPage" aria-disabled="true">Anterior</a>
                </li>
                <li class="page-item active"><a class="page-link" id="firstPage-btn" href="Acciones?action=citas&page=<%= (+pagina != 0) ? (pagina - 1) : pagina%>">1</a></li>
                <li class="page-item" aria-current="page">
                  <a class="page-link" id="secondPage-btn" href="Acciones?action=citas&page=<%= (+pagina != 0) ? pagina : (pagina + 1)%>">2</a>
                </li>
                <li class="page-item"><a id="thirdPage-btn" class="page-link" href="Acciones?action=citas&page=<%= (+pagina != 0) ? (pagina + 1) : (pagina + 2)%>">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="Acciones?action=citas&page=<%= pagina + 1%>" id="nextPage" >Siguiente</a>
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
              <!-- failPaciente modal -->
              <div class="modal fade" id="failMedicoModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="failMedicoModal">Médico no encontrado</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              No se encontró un médico con la identificación y el tipo de identificación indicados. Intente nuevamente.
                          </div>
                          <div class="modal-footer">
                              <button type="button" id="failMedicoModalbtn" class="btn btn-danger" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end failPaciente modal --> 
              <!-- failMedico modal -->
              <div class="modal fade" id="failPacienteModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="failPacienteModal">Paciente no encontrado</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              No se encontró un paciente con la identificación y el tipo de identificación indicados. Intente nuevamente.
                          </div>
                          <div class="modal-footer">
                              <button type="button" id="failPacienteModalbtn" class="btn btn-danger" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end failMedico modal -->    
              <!-- failAvailableModal modal -->
              <div class="modal fade" id="failAvailableModal" tabindex="-1" >
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h5 class="modal-title" id="failAvailableModal">Horario no disponible</h5>
                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                          </div>
                          <div class="modal-body">
                              El horario seleccionado no se encuentra disponible. Verifique los horarios de atención del médico y las citas programadas.
                          </div>
                          <div class="modal-footer">
                              <button type="button" id="failAvailableModalbtn" class="btn btn-danger" data-bs-dismiss="modal">Aceptar</button>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- end failAvailableModal modal -->              
        <input type="hidden" id="page" value="<%= pagina %>">
        <input type="hidden" id="querySize" value="<%= list.size() %>">
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="js/cita/citaIndex.js"></script>
    </body>
</html>
