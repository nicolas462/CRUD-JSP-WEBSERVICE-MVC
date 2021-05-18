package PModelo;

/**
 *
 * @author Nicolas
 */
public class Cita
{
    private int id;
    private int idPaciente;
    private int idMedico;
    private String fecha_solicitada;
    private String fecha_asignada;
    private String hora_asignada;
    private String infMedico;
    private String infPaciente;

    public String getInfMedico() {
        return infMedico;
    }

    public void setInfMedico(String infMedico) {
        this.infMedico = infMedico;
    }

    public String getInfPaciente() {
        return infPaciente;
    }

    public void setInfPaciente(String infPaciente) {
        this.infPaciente = infPaciente;
    }

    public String getHora_asignada() {
        return hora_asignada;
    }

    public void setHora_asignada(String hora_asignada) {
        this.hora_asignada = hora_asignada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getFecha_solicitada() {
        return fecha_solicitada;
    }

    public void setFecha_solicitada(String fecha_solicitada) {
        this.fecha_solicitada = fecha_solicitada;
    }

    public String getFecha_asignada() {
        return fecha_asignada;
    }

    public void setFecha_asignada(String fecha_asignada) {
        this.fecha_asignada = fecha_asignada;
    }
}
