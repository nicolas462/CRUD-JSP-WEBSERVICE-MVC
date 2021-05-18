/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PControlador;

import PModelo.Cita;
import static java.lang.Math.abs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class scheduleValidation 
{
        /**
     * Check if horaDeseada and fechaDeseada are not in the same hour
     * of the stored values
     * @param list = readHoraAsignadaByIdMedico
     * @param horaDeseada = hour to evaluate
     * @param fechaDeseada = date to evaluate
     * @param horarioInicioMedico = horarioInicioMedico got from CRUDMedico
     * @param horarioFinMedico = horarioFinMedico got from CRUDMedico
     * @return 
     */
    public boolean isAvailable(List <Cita> list, String horaDeseada, String fechaDeseada, 
            String horarioInicioMedico, String horarioFinMedico)
    {
        int horaDeseadaInt = Integer.parseInt(horaDeseada.split(":")[0] 
                + horaDeseada.split(":")[1]);
        int horarioInicioMedicoInt = Integer.parseInt(horarioInicioMedico.split(":")[0] 
                + horarioInicioMedico.split(":")[1]);
        int horarioFinMedicoInt = Integer.parseInt(horarioFinMedico.split(":")[0] 
                + horarioFinMedico.split(":")[1]);     
        
        boolean onRange = false;
        
        // if starts at night
        if (horarioInicioMedicoInt > horarioFinMedicoInt)
            onRange = !(horarioInicioMedicoInt > horaDeseadaInt && horarioFinMedicoInt < horaDeseadaInt);
        else
            onRange = !(horarioInicioMedicoInt > horaDeseadaInt || horarioFinMedicoInt < horaDeseadaInt);
        
        if (!onRange) //if horaDeseada is not on range
            return onRange;
        
        for (Cita cita : list)
        {
            int horaAsignadaInt = Integer.parseInt(cita.getHora_asignada().split(":")[0] 
                    + cita.getHora_asignada().split(":")[1]);          
            
            String fechaAsignada = cita.getFecha_asignada();
            
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date dateFechaAsignada = new Date();
            Date dateFechaDeseada = new Date();
            try 
            {
                dateFechaAsignada = simpleDateFormat.parse(fechaAsignada);
                dateFechaDeseada = simpleDateFormat.parse(fechaDeseada);
                
                if(dateFechaAsignada.compareTo(dateFechaDeseada) == 0) //if they're the same day
                {
                    if( abs(horaAsignadaInt -  horaDeseadaInt) < 100 ) // less than one hour
                        return false;
                }
            } catch (ParseException ex) {
                return false;
            }            
        }
        return true ;
    }
        
}