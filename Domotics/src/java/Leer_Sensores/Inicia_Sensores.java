/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

/**
 *
 * @author eduardo
 */
public class Inicia_Sensores {

    public static void main (String[] args) {
        
        // IMPORTANTE //
        //este codigo deberia estar en el inicio del sistema
        Hilo_Sensores hilo = new Hilo_Sensores();
        hilo.start();
        
        
        
    }
}


