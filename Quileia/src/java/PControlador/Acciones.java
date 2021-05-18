package PControlador;

import PModelo.CRUDCita;
import PModelo.CRUDMedico;
import PModelo.CRUDPaciente;
import PModelo.Cita;
import PModelo.Medico;
import PModelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
@WebServlet(name = "Acciones", urlPatterns = {"/Acciones"})
public class Acciones extends HttpServlet 
{
    String index = "index.jsp";
    String create = "Vista/create.jsp";
    String update = "Vista/update.jsp";
    String edit = "Vista/edit.jsp";
    String searchMedico = "Vista/searchMedico.jsp";
    Medico medico = new Medico();
    CRUDMedico crud = new CRUDMedico();
    int id;
    int flag;
    
    Paciente paciente = new Paciente();
    CRUDPaciente crudPaciente = new CRUDPaciente();
    String pacientes = "Vista/pacientes/pacientes.jsp";
    String updatePaciente = "Vista/pacientes/update.jsp";
    String createPaciente = "Vista/pacientes/create.jsp";
    String searchPaciente = "Vista/pacientes/searchPaciente.jsp";
    
    Cita cita = new Cita();
    CRUDCita crudCita = new CRUDCita();
    scheduleValidation schV = new scheduleValidation();
    String citas = "Vista/citas/citas.jsp";
    String updateCita = "Vista/citas/update.jsp";
    String createCita = "Vista/citas/create.jsp";    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Acciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Acciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException 
    {
        String page = "";
        String action = request.getParameter("action");
         
        switch (action.toUpperCase()) //ignorecase
        {
            // medico
            
            case "INDEX":
                page = index;
            break;       
            
            case "ANADIRMEDICO":
                page = create;
            break;

            case "SEARCHMEDICO":
                page = searchMedico;
            break;
            
            case "AGREGAR":
                String nombreA = request.getParameter("nombreMedico");
                String identificacionA = request.getParameter("identificacionMedico");
                String tipoIdA = request.getParameter("tipoIDMedico");
                String numTarjetaA = request.getParameter("tarjetaProfesionalMedico");
                double anosExpA = Double.parseDouble(request.getParameter("anosExpMedico"));
                String especialidadA = request.getParameter("especializacionMedico");
                String HoraInicioAtencionA = request.getParameter("horaInicioMedico");
                String MinutosInicioAtencionA = request.getParameter("minutosInicioMedico");
                String HoraFinAtencionA = request.getParameter("horaFinMedico");
                String MinutosFinAtencionA = request.getParameter("minutosFinMedico");
                
                medico.setNombre(nombreA);
                medico.setIdentificacion(identificacionA);
                medico.setTipoID(tipoIdA);
                medico.setNumTarjetaProf(numTarjetaA);
                medico.setAnosExp(anosExpA);
                medico.setEspecialidad(especialidadA);
                medico.setHoraInicio(HoraInicioAtencionA + ":" + MinutosInicioAtencionA);
                medico.setHoraFin(HoraFinAtencionA + ":" + MinutosFinAtencionA);
                
                int flagA = 2;
                if(crud.checkByIdentificacionAndTipoId(identificacionA, tipoIdA))
                    flagA = 3; //exists
                else
                    flagA = (crud.create(medico)) ? 1 : 2; // 1 = excecuted - 2 = failed   
                
                page = index + "?flag="+flagA;
            break;
            
            case "UPDATE":
                page = update;
            break;
            
            case "GUARDAR CAMBIOS":
                id = Integer.parseInt(request.getParameter("medicoId"));
                String nombre = request.getParameter("nombreMedico");
                String identificacion = request.getParameter("identificacionMedico");
                String tipoId = request.getParameter("tipoIDMedico");
                String numTarjeta = request.getParameter("tarjetaProfesionalMedico");
                double anosExp = Double.parseDouble(request.getParameter("anosExpMedico"));
                String especialidad = request.getParameter("especializacionMedico");
                String HoraInicioAtencion = request.getParameter("horaInicioMedico");
                String MinutosInicioAtencion = request.getParameter("minutosInicioMedico");
                String HoraFinAtencion = request.getParameter("horaFinMedico");
                String MinutosFinAtencion = request.getParameter("minutosFinMedico");

                medico.setId(id);
                medico.setNombre(nombre);
                medico.setIdentificacion(identificacion);
                medico.setTipoID(tipoId);
                medico.setNumTarjetaProf(numTarjeta);
                medico.setAnosExp(anosExp);
                medico.setEspecialidad(especialidad);
                medico.setHoraInicio(HoraInicioAtencion + ":" + MinutosInicioAtencion);
                medico.setHoraFin(HoraFinAtencion + ":" + MinutosFinAtencion);
                
                if(crud.checkByIdentificacionAndTipoId(identificacion, tipoId))
                    flag = 3; //exists
                else
                    flag = (crud.update(medico)) ? 1 : 2; // 1 = excecuted - 2 = failed
                
                page = index + "?flag="+flag;
            break;
            
            case "DELETEMEDICO":
                id = Integer.parseInt(request.getParameter("id"));
                flag = (crud.delete(id)) ? 1 : 2; // 1 = excecuted - 2 = failed
                
                page = index + "?flag="+flag;
            break;
            
            // Pacientes
            
            case "PACIENTES":
                page = pacientes;
            break;
            
            case "UPDATEPACIENTE":
                page = updatePaciente;
            break;
            
            case "SEARCHPACIENTE":
                page = searchPaciente;
            break;            
            
            case "ACTUALIZAR PACIENTE":

                id = Integer.parseInt(request.getParameter("pacienteId"));
                String nombrePaciente = request.getParameter("nombrePaciente");
                String identificacionPaciente = request.getParameter("identificacionPaciente");
                String tipoIdPaciente = request.getParameter("tipoIDPaciente");
                String fechaNacimientoPaciente =  request.getParameter("fechaNacimientoPaciente");
                String epsPaciente = request.getParameter("epsPaciente");
                String historiaClinicaPaciente = request.getParameter("historiaClinicaPaciente");

                paciente.setId(id);
                paciente.setNombre(nombrePaciente);
                paciente.setIdentificacion(identificacionPaciente);
                paciente.setTipoID(tipoIdPaciente);
                paciente.setFechaNacimiento(fechaNacimientoPaciente);
                paciente.setEps(epsPaciente);
                paciente.setHistoriaClinica(historiaClinicaPaciente);
                
                if(crudPaciente.checkByIdentificacionAndTipoId(identificacionPaciente, tipoIdPaciente))
                    flagA = 3; //exists
                else
                    flag = (crudPaciente.update(paciente)) ? 1 : 2; // 1 = excecuted - 2 = failed
                
                page = pacientes + "?flag="+flag;
            break;
            
            case "DELETEPACIENTE":
                id = Integer.parseInt(request.getParameter("id"));
                flag = (crudPaciente.delete(id)) ? 1 : 2; // 1 = excecuted - 2 = failed
                
                page = pacientes + "?flag="+flag;
            break;
            
            case "ANADIRPACIENTE":
                page = createPaciente;
            break;
            
            case "AGREGAR PACIENTE":
                String nombreP = request.getParameter("nombrePaciente");
                String identificacionP = request.getParameter("identificacionPaciente");
                String tipoIdP = request.getParameter("tipoIDPaciente");
                String fechaNacimiento = request.getParameter("fechaNacimientoPaciente");
                String eps = request.getParameter("epsPaciente");
                String historiaClinica = request.getParameter("historiaClinicaPaciente");
 
                paciente.setNombre(nombreP);
                paciente.setIdentificacion(identificacionP);
                paciente.setTipoID(tipoIdP);
                paciente.setFechaNacimiento(fechaNacimiento);
                paciente.setEps(eps);
                paciente.setHistoriaClinica(historiaClinica);
                
                int flagP = 2;
                
                if(crudPaciente.checkByIdentificacionAndTipoId(identificacionP, tipoIdP))
                    flagP = 3; //exists
                else
                    flagP = (crudPaciente.create(paciente)) ? 1 : 2; // 1 = excecuted - 2 = failed
                
                page = pacientes + "?flag="+flagP;
            break;  
            
            // CITAS
            
            case "CITAS":
                page = citas;
            break;
                       
            case "ANADIRCITA":
                page = createCita;
            break;
            
            case "ASIGNAR CITA":

                String identificacionPacienteCita = request.getParameter("documentoPacienteCita");
                String tipoIdPacienteCita = request.getParameter("tipoIDPacienteCita");
                String identificacionMedicoCita = request.getParameter("documentoMedicoCita");
                String tipoIdMedicoCita = request.getParameter("tipoIDMedicoCita");

                paciente.setNombre(null);
                medico.setNombre(null);
                
                paciente = crudPaciente.readByIdAndTipoId(identificacionPacienteCita, tipoIdPacienteCita);
                medico = crud.readByIdAndTipoId(identificacionMedicoCita, tipoIdMedicoCita);
                
                int flagC = 4;
                
                if (paciente.getNombre() == null)
                {
                    flagC = 2; // paciente not found                   
                    page= citas + "?flag="+flagC;
                } 
                else if (medico.getNombre() == null)
                {
                    flagC =  3; //  3 = medico not found    
                    page = citas + "?flag="+flagC; 
                }
                else
                {
                    String fechaSolicitada = request.getParameter("fechaSolicitadaCita");
                    String fechaAsignadaCita = request.getParameter("fechaAsignadaCita");                    
                    String horaAsignadaCita = request.getParameter("horaAsignadaCita");   
                    String minutoAsignadoCita = request.getParameter("minutoAsignadoCita");
                    
                    cita.setFecha_solicitada(fechaSolicitada);
                    cita.setIdPaciente(paciente.getId());
                    cita.setIdMedico(medico.getId());
                    cita.setFecha_asignada(fechaAsignadaCita);
                    cita.setHora_asignada(horaAsignadaCita + ":" + minutoAsignadoCita);
                    
                    medico = crud.readHorarioByIdMedico(cita.getIdMedico());
                    
                    boolean isAvailable = schV.isAvailable(
                            crudCita.readHoraAsignadaByIdMedico(cita.getIdMedico()), 
                            horaAsignadaCita+":"+minutoAsignadoCita, fechaAsignadaCita, 
                            medico.getHoraInicio(), medico.getHoraFin()
                    );
                    
                    if (isAvailable)
                    {
                        flagC = (crudCita.create(cita)) ? 1 : 4; // 1 - success / 4 - fail
                        page = citas + "?flag="+flagC;
                    }
                    else{
                        flagC = 5; // 5 - notAvailable
                        page = citas + "?flag="+flagC;
                    }
                }
            break;          
        }
               
        RequestDispatcher vista = request.getRequestDispatcher(page);
        vista.forward(request,  response);
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
        processRequest(request, response);
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
