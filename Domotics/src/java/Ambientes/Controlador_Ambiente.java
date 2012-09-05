/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Fabricas.Fabrica_Expertos;

/**
 *
 * @author eduardo
 */
public class Controlador_Ambiente {
    
    Experto_Ambiente expertoAmbiente;

    public Controlador_Ambiente() {
        
        expertoAmbiente = (Experto_Ambiente) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Ambiente);
        
    }


    
    
    
}
