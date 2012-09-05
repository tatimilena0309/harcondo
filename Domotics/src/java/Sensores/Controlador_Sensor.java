/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensores;

import Fabricas.Fabrica_Expertos;
import Negocio.Modelo_Sensor;
import Negocio.Sensor;
import java.util.List;

/**
 *
 * @author LEO
 */
public class Controlador_Sensor {
    
    
    
    Experto_Sensor experto;

    public Controlador_Sensor() {
        
        experto = (Experto_Sensor) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Sensores);
    }
    
    
    
    public List<Modelo_Sensor> getModelosSensores(){
        return experto.getModelosSensores();
    }

    public Sensor Alta_Sensor(int numero, String numero_serie, String modelo){
        return experto.Alta_Sensor(numero, numero_serie, modelo);
    }
    
}