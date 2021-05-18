package PModelo;

import PConnection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class CRUDPaciente
{
    Connect cn = new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Paciente p = new Paciente();

    public boolean create(Paciente paciente) 
    {        
        String query = "INSERT INTO paciente (`nombre`, "
                + "`fecha_nacimiento`, `identificacion`, `tipo_identificacion`"
                + ", `eps`, `historia_clinica`) "
                + "VALUES ('" + paciente.getNombre()
                + "','" + paciente.getFechaNacimiento()
                + "','" + paciente.getIdentificacion()
                + "','" + paciente.getTipoID()
                + "','" + paciente.getEps()
                + "','" + paciente.getHistoriaClinica() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

        /**
     * read by param given
     * @param col = column to find
     * @param param = param to find
     * @return 
     */
    public List readByParam(String col, String param, int firstLimit, int secondLimit) 
    {
        ArrayList <Paciente> list = new ArrayList<>();
        String query = "SELECT * FROM paciente WHERE "+col+" LIKE "
                + "'%"+param+"%'";
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Paciente pa = new Paciente();
                
                pa.setId(rs.getInt("idPaciente"));
                pa.setNombre(rs.getString("nombre"));
                pa.setIdentificacion(rs.getString("identificacion"));
                pa.setTipoID(rs.getString("tipo_identificacion"));
                pa.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                pa.setEps(rs.getString("eps"));
                pa.setHistoriaClinica(rs.getNString("historia_clinica")); 
                list.add(pa);
            }
        } catch (Exception e) {
        }
        return list;
    }  
    
    /**
     * check if there's a row with the Identificacion and TipoId
     * @param identificacion
     * @param tipoId
     * @return true if it exists
     */
    public boolean checkByIdentificacionAndTipoId(String identificacion, String tipoId)
    {
        String query = "SELECT * FROM paciente WHERE identificacion = "
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
    
    public List readByLimit(int firstLimit, int secondLimit) 
    {
        ArrayList <Paciente> list = new ArrayList<>();
        String query = "SELECT * FROM paciente LIMIT "+firstLimit+","+secondLimit;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Paciente pa = new Paciente();

                pa.setId(rs.getInt("idPaciente"));
                pa.setNombre(rs.getString("nombre"));
                pa.setIdentificacion(rs.getString("identificacion"));
                pa.setTipoID(rs.getString("tipo_identificacion"));
                pa.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                pa.setEps(rs.getString("eps"));
                pa.setHistoriaClinica(rs.getNString("historia_clinica")); 
                list.add(pa);
            }
        } catch (Exception e) {
        }
        return list;
    }

    /*public static void main(String args[]) 
    {
        CRUDPaciente crud = new CRUDPaciente();
        Paciente paciente = new Paciente();
        
        paciente = crud.readByIdAndTipoId("19008844","CC");
        
        System.out.println(paciente.getNombre());
    }*/
    
    public Paciente readByIdAndTipoId(String identificacionPaciente, String tipoId) 
    {
        String query = "SELECT * FROM paciente WHERE identificacion='" + identificacionPaciente
                + "' AND tipo_identificacion='" + tipoId + "'";
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                p.setId(rs.getInt("idPaciente"));
                p.setNombre(rs.getString("nombre"));
                p.setIdentificacion(rs.getString("identificacion"));
                p.setTipoID(rs.getString("tipo_identificacion"));
                p.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                p.setEps(rs.getString("eps"));
                p.setHistoriaClinica(rs.getString("historia_clinica"));                 
            }
        } catch (Exception e) 
        {
            return p;
        }
        return p;
    }
    
    public Paciente readById(int id) 
    {

        String query = "SELECT * FROM paciente WHERE idPaciente=" + id;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                p.setId(rs.getInt("idPaciente"));
                p.setNombre(rs.getString("nombre"));
                p.setIdentificacion(rs.getString("identificacion"));
                p.setTipoID(rs.getString("tipo_identificacion"));
                p.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                p.setEps(rs.getString("eps"));
                p.setHistoriaClinica(rs.getString("historia_clinica"));                 
            }
        } catch (Exception e) 
        {
        }
        return p;
    }
    
    public boolean update(Paciente paciente) 
    {
        String query = "UPDATE paciente SET nombre='" + paciente.getNombre() + 
                "',fecha_nacimiento='" + paciente.getFechaNacimiento()+
                "',identificacion='" + paciente.getIdentificacion()+ 
                "',tipo_identificacion='" + paciente.getTipoID()+ 
                "',eps='" + paciente.getEps() + 
                "',historia_clinica='" + paciente.getHistoriaClinica()+
                "' WHERE idPaciente ="+paciente.getId();
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
        String query = "DELETE FROM paciente WHERE idPaciente=" + id;
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