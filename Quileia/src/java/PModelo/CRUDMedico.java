package PModelo;

import PConnection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class CRUDMedico
{
    Connect cn = new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Medico m = new Medico();

    /**
     * check if there's a row with the Identificacion and TipoId
     * @param identificacion
     * @param tipoId
     * @return true if it exists
     */
    public boolean checkByIdentificacionAndTipoId(String identificacion, String tipoId)
    {
        String query = "SELECT * FROM medico WHERE identificacion = "
                + "'"+identificacion+"' AND tipo_identificacion = '"+tipoId+"'";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception ex)
        {
            return false;
        }
    }

    public boolean create(Medico medico) 
    {        
        String query = "INSERT INTO medico (nombre,identificacion,"
                + "tipo_identificacion,numero_tarjeta,anos_experiencia,"
                + "especialidad,inicio_atencion,fin_atencion)"
                + "VALUES ('" + medico.getNombre() 
                + "','" + medico.getIdentificacion()
                + "','" + medico.getTipoID()
                + "','" + medico.getNumTarjetaProf()
                + "','" + medico.getAnosExp()
                + "','" + medico.getEspecialidad()
                + "','" + medico.getHoraInicio()
                + "','" + medico.getHoraFin()
                + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Medico readHorarioByIdMedico(int id) 
    {
        String query = "SELECT inicio_atencion,fin_atencion FROM medico WHERE idMedico="+id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                m.setHoraInicio(rs.getString("inicio_atencion"));
                m.setHoraFin(rs.getString("fin_atencion"));
            }
        } catch (Exception e) {
            return m;
        }
        return m;
    }    
    
    public Medico readByIdAndTipoId(String identificacionMedico, String tipoId) 
    {
        String query = "SELECT * FROM medico WHERE identificacion='" + identificacionMedico
                + "' AND tipo_identificacion='" + tipoId + "'";
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                m.setId(rs.getInt("idMedico"));
                m.setNombre(rs.getString("nombre"));
                m.setIdentificacion(rs.getString("identificacion"));
                m.setTipoID(rs.getString("tipo_identificacion"));
                m.setNumTarjetaProf(rs.getString("numero_tarjeta"));
                m.setAnosExp(rs.getFloat("anos_experiencia"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setHoraInicio(rs.getString("inicio_atencion"));
                m.setHoraFin(rs.getString("fin_atencion"));              
            }
        } catch (Exception e)
        {
            return m;            
        }
        return m;
    }
    
    public Medico readById(int id) 
    {
        String query = "SELECT * FROM medico WHERE idMedico=" + id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                m.setId(rs.getInt("idMedico"));
                m.setNombre(rs.getString("nombre"));
                m.setIdentificacion(rs.getString("identificacion"));
                m.setTipoID(rs.getString("tipo_identificacion"));
                m.setNumTarjetaProf(rs.getString("numero_tarjeta"));
                m.setAnosExp(rs.getFloat("anos_experiencia"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setHoraInicio(rs.getString("inicio_atencion"));
                m.setHoraFin(rs.getString("fin_atencion"));
                
            }
        } catch (Exception e) {
        }
        return m;
    }
    
    public boolean update(Medico medico) 
    {
        String query = "UPDATE medico SET nombre='" + medico.getNombre() + 
                "',identificacion='" + medico.getIdentificacion()+ 
                "',tipo_identificacion='" + medico.getTipoID()+ 
                "',numero_tarjeta='" + medico.getNumTarjetaProf() + 
                "',anos_experiencia=" + medico.getAnosExp() +
                ",especialidad='" + medico.getEspecialidad()+
                "',inicio_atencion='" + medico.getHoraInicio()+
                "',fin_atencion='" + medico.getHoraFin() +
                "' WHERE idMedico=" + medico.getId();
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
        String query = "DELETE FROM medico WHERE idMedico=" + id;
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

    public List<pwebservices.Medico> listarMedicos(int firstLimit, int secondLimit) 
    {
        pwebservices.WSListMedicos_Service service = new pwebservices.WSListMedicos_Service();
        pwebservices.WSListMedicos port = service.getWSListMedicosPort();
        return port.listarMedicos(firstLimit, secondLimit);
    }

    public java.util.List<pwebservices.Medico> readByParam(java.lang.String arg0,
            java.lang.String arg1, int arg2, int arg3)
    {
        pwebservices.WSListMedicos_Service service = new pwebservices.WSListMedicos_Service();
        pwebservices.WSListMedicos port = service.getWSListMedicosPort();
        return port.readByParam(arg0, arg1, arg2, arg3);
    }


}
