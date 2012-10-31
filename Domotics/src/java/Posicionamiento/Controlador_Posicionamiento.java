/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Posicionamiento;

import Adaptador_Sensores.Observador_Sensores;
import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;


/**
 *
 * @author eduu
 */
public class Controlador_Posicionamiento extends Controlador implements Observador_Sensores{

   
    Experto_Posicionamiento experto;
    
    public Controlador_Posicionamiento() {
    
        experto = (Experto_Posicionamiento) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Posicionamiento);
        
    
    }

    public void notificarMovimiento() {
        //aca tiene qie llamar a la libreria que reproduce audio para indicar que esta entrando a un
        //ambiente
    }
    
    
    

    
        
    
    
    
}
