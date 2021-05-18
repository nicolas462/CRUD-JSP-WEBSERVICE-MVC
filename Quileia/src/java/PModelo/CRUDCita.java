package PModelo;

import PConnection.Connect;
import static java.lang.Math.abs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class CRUDCita
{
    Connect cn = new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cita c = new Cita();

    public boolean create(Cita cita) 
    {        
        String query = "INSERT INTO cita (`fecha_solicitada`, "
                + "`idPaciente`, `idMedico`, `fecha_asignada`, `hora_asignada`)"
                + "VALUES ('" + cita.getFecha_solicitada()
                + "','" + cita.getIdPaciente()
                + "','" + cita.getIdMedico()
                + "','" + cita.getFecha_asignada()
                + "','" + cita.getHora_asignada() + "')";
        System.out.println(query);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List read() 
    {
        ArrayList <Cita> list = new ArrayList<>();

        String query = "SELECT sq.idCita, sq.fecha_solicitada, "
                + "sq.idPaciente, paciente.nombre AS 'nomPaciente', "
                + "paciente.identificacion AS 'identPaciente', "
                + "paciente.tipo_identificacion AS 'tipoIdPaciente' ,"
                + "sq.idMedico, sq.nomMedico, "
                + "sq.identMedico, sq.tipoIdMedico, "
                + "sq.fecha_asignada, sq.hora_asignada "
                + "FROM paciente INNER JOIN "
                + "(SELECT cita.idCita, cita.fecha_solicitada, "
                + "cita.idPaciente, cita.idMedico, "
                + "medico.nombre AS 'nomMedico', "
                + "medico.identificacion AS 'identMedico', "
                + "medico.tipo_identificacion AS 'tipoIdMedico', "
                + "cita.fecha_asignada, cita.hora_asignada "
                + "FROM cita INNER JOIN medico "
                + "ON cita.idMedico = medico.idMedico) AS sq "
                + "ON sq.idPaciente = paciente.idPaciente";
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cita cita = new Cita();
                
                cita.setId(rs.getInt("idCita"));
                cita.setFecha_solicitada(rs.getString("fecha_solicitada"));
                cita.setIdPaciente(rs.getInt("idPaciente"));
                cita.setIdMedico(rs.getInt("idMedico"));
                cita.setFecha_asignada(rs.getString("fecha_asignada"));
                cita.setHora_asignada(rs.getString("hora_asignada"));
                
                cita.setInfPaciente(rs.getString("nomPaciente")+","
                                + rs.getString("identPaciente") +","
                                + rs.getString("tipoIdPaciente"));

                cita.setInfMedico(rs.getString("nomMedico")+","
                                + rs.getString("identMedico") +","
                                + rs.getString("tipoIdMedico"));
                list.add(cita);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List readByLimit(int firstLimit, int secondLimit) 
    {
        ArrayList <Cita> list = new ArrayList<>();

        String query = "SELECT sq.idCita, sq.fecha_solicitada, "
                + "sq.idPaciente, paciente.nombre AS 'nomPaciente', "
                + "paciente.identificacion AS 'identPaciente', "
                + "paciente.tipo_identificacion AS 'tipoIdPaciente' ,"
                + "sq.idMedico, sq.nomMedico, "
                + "sq.identMedico, sq.tipoIdMedico, "
                + "sq.fecha_asignada, sq.hora_asignada "
                + "FROM paciente INNER JOIN "
                + "(SELECT cita.idCita, cita.fecha_solicitada, "
                + "cita.idPaciente, cita.idMedico, "
                + "medico.nombre AS 'nomMedico', "
                + "medico.identificacion AS 'identMedico', "
                + "medico.tipo_identificacion AS 'tipoIdMedico', "
                + "cita.fecha_asignada, cita.hora_asignada "
                + "FROM cita INNER JOIN medico "
                + "ON cita.idMedico = medico.idMedico) AS sq "
                + "ON sq.idPaciente = paciente.idPaciente LIMIT " +firstLimit +","
                +secondLimit;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cita cita = new Cita();
                
                cita.setId(rs.getInt("idCita"));
                cita.setFecha_solicitada(rs.getString("fecha_solicitada"));
                cita.setIdPaciente(rs.getInt("idPaciente"));
                cita.setIdMedico(rs.getInt("idMedico"));
                cita.setFecha_asignada(rs.getString("fecha_asignada"));
                cita.setHora_asignada(rs.getString("hora_asignada"));
                
                cita.setInfPaciente(rs.getString("nomPaciente")+","
                                + rs.getString("identPaciente") +","
                                + rs.getString("tipoIdPaciente"));

                cita.setInfMedico(rs.getString("nomMedico")+","
                                + rs.getString("identMedico") +","
                                + rs.getString("tipoIdMedico"));
                list.add(cita);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List readHoraAsignadaByIdMedico(int id) 
    {
        ArrayList <Cita> list = new ArrayList<>();
        String query = "SELECT fecha_asignada,hora_asignada FROM cita WHERE idMedico="+id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cita cita = new Cita();

                cita.setFecha_asignada(rs.getString("fecha_asignada"));
                cita.setHora_asignada(rs.getString("hora_asignada"));

                list.add(cita);
            }
        } catch (Exception e) {
            return list;
        }
        return list;
    }    
    
   /*public static void main(String args[]) 
    {
        CRUDCita crud = new CRUDCita();
        System.out.println(crud.readByLimit(0,10));
    }*/
    
    public Cita readById(int id) 
    {
        String query = "SELECT * FROM cita WHERE idCita=" + id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                c.setFecha_solicitada(rs.getString("fechaSolicitadaCita"));
                c.setIdPaciente(rs.getInt("idPacienteCita"));
                c.setIdMedico(rs.getInt("idPacienteMedico"));
                c.setFecha_asignada(rs.getString("fechaAsignadaCita"));
                c.setHora_asignada(rs.getString("hora_asignada"));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    public boolean update(Cita cita) 
    {
        String query = "UPDATE cita SET "
                + "fecha_solicitada='" + cita.getFecha_solicitada()
                + "'idPaciente='" + cita.getIdPaciente()
                + "'idMedico='" + cita.getIdMedico()
                + "'fecha_asignada='" + cita.getFecha_asignada()
                + "'hora_asignada='" + cita.getHora_asignada()
                + "' WHERE idCita=" + cita.getId();
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) 
        {
            return false;
        }
        return true;
    }

    public boolean delete(int id) 
    {
        String query = "DELETE FROM cita WHERE idCita=" + id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}