/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Leo
 */
public class formateador_fechas {

    public static formateador_fechas instance = new formateador_fechas();
    
    public static formateador_fechas getInstance(){return instance;}

    public Date getFecha(String fecha){

        try {
            String str_date=fecha;
            DateFormat formatter ;
            Date date ; 
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            date = (Date)formatter.parse(str_date);
            Calendar cal=Calendar.getInstance();
            cal.setTime(date);
            System.out.println("Today is " +date );
            return date;
        }
        catch (ParseException e)
        {
            System.out.println("Exception :"+e);
            return null;
        }
        
    }

    /**
     * Devuelve fecha y hora en string
     * @param fecha
     * @return 
     */
    public String getFecha_y_Hora(Date fecha){
        
        String fecha_hora = fecha.getDay() + "/" + fecha.getMonth() + "/" + (1900 +fecha.getYear()) + " hora: " + fecha.getHours()+ ":" + fecha.getMinutes();
        return fecha_hora;
    }
    
     /**
     * Devuelve fecha en string
     * @param fecha
     * @return 
     */
    public String getFecha(Date fecha){
        
        String fecha_hora = fecha.getDay() + "/" + fecha.getMonth() + "/" + (1900 +fecha.getYear());
        return fecha_hora;
    }
    
    
    

}
