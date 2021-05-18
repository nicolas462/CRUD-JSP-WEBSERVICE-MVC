package PModelo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Nicolas
 */
public class Medico extends User
{
    private String numTarjetaProf;
    private double anosExp;
    private String especialidad;
    private String horaInicio;
    private String horaFin;
    NumberFormat formatter = new DecimalFormat("#0.0");  
    

    public String getNumTarjetaProf() {
        return numTarjetaProf;
    }

    public void setNumTarjetaProf(String numTarjetaProf) {
        this.numTarjetaProf = numTarjetaProf;
    }

    public double getAnosExp() {
        return anosExp;
    }

    public void setAnosExp(double anosExp) {
        this.anosExp = anosExp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    
}
