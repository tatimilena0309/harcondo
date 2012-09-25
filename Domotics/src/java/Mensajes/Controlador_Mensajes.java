/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import Fabricas.Fabrica_Expertos;
import Negocio.Mensaje;

/**
 *
 * @author LEO
 */
public class Controlador_Mensajes {
    
    Experto_Mensajes experto;

    public Controlador_Mensajes() {
        
        experto = (Experto_Mensajes) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Mensajes);
        
    }
    
    public Mensaje crearMensaje(String nombre, String descripcion, String tipo){
        
        return experto.crearMensaje(nombre, descripcion, tipo);
    
    }

}
