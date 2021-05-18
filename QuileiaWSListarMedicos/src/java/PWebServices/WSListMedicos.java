package PWebServices;

import PModelo.CRUDMedico;
import PModelo.Medico;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author Nicolas
 */
@WebService(serviceName = "WSListMedicos")
public class WSListMedicos 
{
    CRUDMedico crud = new CRUDMedico();
    @WebMethod(operationName = "listarMedicos")
    public List <Medico> list(int firstLimit, int secondLimit) 
    {
        List <Medico> a = crud.readByLimit(firstLimit, secondLimit);
        return  a;
    }

    @WebMethod(operationName = "readByParam")
    public List <Medico> readByParam(String col, String param, int firstLimit, int secondLimit) 
    {
        List <Medico> a = crud.readByParam(col, param, firstLimit, secondLimit);
        return  a;
    }    
}
