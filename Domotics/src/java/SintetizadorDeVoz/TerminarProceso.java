/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SintetizadorDeVoz;

import java.io.IOException;

/**
 *
 * @author eduardo
 */
public class TerminarProceso {

        
    static void terminarProceso(String nombreProceso){
        
        String osName = System.getProperty("os.name");
        String system =  "";
        if(osName.toUpperCase().contains("WIN")){   //Windows
            system+="tskill " + nombreProceso;
        }      

        Process hijo;
        try {
            hijo = Runtime.getRuntime().exec(system);
            hijo.waitFor();
            if ( hijo.exitValue()==0){
                System.out.println( "se ha cerrado la música");
            }else{
		System.out.println( "No se puede cerrrar la música" );
            }
        } catch (IOException e) {
            System.out.println("Incapaz de matar soffice.");
        } catch (InterruptedException e) {
            System.out.println("Incapaz de matar soffice.");
        }      
        
        
    }
    
    
}
