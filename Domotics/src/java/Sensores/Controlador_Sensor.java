/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensores;

import Negocio.Modelo_Sensor;
import Negocio.Sensor;
import java.util.List;

/**
 *
 * @author LEO
 */
public class Controlador_Sensor {
    
    Experto_Sensor experto = new Experto_Sensor();
    
    public List<Modelo_Sensor> getModelosSensores(){
        return experto.getModelosSensores();
    }

    public Sensor Alta_Sensor(int numero, String numero_serie, String Modelo){
        return null;
                //experto.Alta_Sensor(numero, numero_serie, modelo);
    }
    
}
