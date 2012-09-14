/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import Negocio.Ambiente;

/**
 *
 * @author eduardo
 */
public class Controlador_Ambiente extends Controlador{
    
    Experto_Ambiente experto;

    public Controlador_Ambiente() {
        
        experto = (Experto_Ambiente) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Ambiente);
        
    }

     public Ambiente Alta_Ambiente(String nombre, String descripcion, String nro_sensor, String mensaje){
         return experto.Alta_Ambiente(nombre, descripcion, nro_sensor, mensaje);
     }
    
    
    
}
