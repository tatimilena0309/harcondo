/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Leer_Sensores;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;

/**
 *
 * @author eduu
 */
public class Controlador_Leer_Sensores extends Controlador {

    Experto_Leer_Sensores experto;

    public Controlador_Leer_Sensores() {

        experto = (Experto_Leer_Sensores) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Leer_Sensores);

    }
    
    
    
    
}
