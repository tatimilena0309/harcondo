/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptador_Sensores;

import Negocio.Ambiente;
import Negocio.Sensor;

/**
 *
 * @author eduu
 */
public interface Observador_Sensores {

    
    public void notificarMovimiento(Ambiente ambiente, Sensor sensor);
    
    
    
}
