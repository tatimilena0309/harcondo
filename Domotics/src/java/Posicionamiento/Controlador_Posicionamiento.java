/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Posicionamiento;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;


/**
 *
 * @author eduu
 */
public class Controlador_Posicionamiento extends Controlador{

   
    Experto_Posicionamiento experto;
    
    public Controlador_Posicionamiento() {
    
        experto = (Experto_Posicionamiento) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Posicionamiento);
        
    
    }

    
        
    
    
    
}
