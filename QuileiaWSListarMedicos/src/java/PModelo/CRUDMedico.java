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
public class CRUDMedico
{
    Connect cn = new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Medico m = new Medico();

    public List readByLimit(int firstLimit, int secondLimit) 
    {
        ArrayList <Medico> list = new ArrayList<>();
        String query = "SELECT * FROM medico LIMIT "+firstLimit+","+secondLimit;
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medico med = new Medico();

                med.setId(rs.getInt("idMedico"));
                med.setNombre(rs.getString("nombre"));
                med.setIdentificacion(rs.getString("identificacion"));
                med.setTipoID(rs.getString("tipo_identificacion"));
                med.setNumTarjetaProf(rs.getString("numero_tarjeta"));
                med.setAnosExp(rs.getFloat("anos_experiencia"));
                med.setEspecialidad(rs.getString("especialidad"));
                med.setHoraInicio(rs.getString("inicio_atencion"));
                med.setHoraFin(rs.getString("fin_atencion"));
                
                list.add(med);
            }
        } catch (Exception e) {
        }
        return list;
    }   
    
    /**
     * read by param given
     * @param col = column to find
     * @param param = param to find
     * @return 
     */
    public List readByParam(String col, String param, int firstLimit, int secondLimit) 
    {
        ArrayList <Medico> list = new ArrayList<>();
        String query = "SELECT * FROM medico WHERE "+col+" LIKE "
                + "'%"+param+"%'";
        try 
        {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medico med = new Medico();

                med.setId(rs.getInt("idMedico"));
                med.setNombre(rs.getString("nombre"));
                med.setIdentificacion(rs.getString("identificacion"));
                med.setTipoID(rs.getString("tipo_identificacion"));
                med.setNumTarjetaProf(rs.getString("numero_tarjeta"));
                med.setAnosExp(rs.getFloat("anos_experiencia"));
                med.setEspecialidad(rs.getString("especialidad"));
                med.setHoraInicio(rs.getString("inicio_atencion"));
                med.setHoraFin(rs.getString("fin_atencion"));
                
                list.add(med);
            }
        } catch (Exception e) {
        }
        return list;
    }    
}