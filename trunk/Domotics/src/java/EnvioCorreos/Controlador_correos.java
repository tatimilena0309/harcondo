/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnvioCorreos;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import persistencia.Fachada_Persistencia;

/**
 *
 * @author edu
 */
public class Controlador_correos extends Controlador {

    Experto_Correos experto;

    public Controlador_correos() {

        experto = (Experto_Correos) Fabricas.Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Correos);

    }
    
    
    public void enviarCorreo(String origen, String destino, String Asunto, String mensaje){
        
        experto.Send(origen,destino, Asunto, mensaje);
        
    }
    
    
}
