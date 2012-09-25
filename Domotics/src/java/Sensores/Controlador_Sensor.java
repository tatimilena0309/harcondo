/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensores;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import Negocio.Estado_Sensor;
import Negocio.Modelo_Sensor;
import Negocio.Sensor;
import java.util.List;

/**
 *
 * @author LEO
 */
public class Controlador_Sensor extends Controlador{
    
    
    
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
    
   /**
   * Devuelve un List<Sensor> con los objetos de la clase Sensor
   * @return 
   */
     public List<Sensor> getSensores(){
        return experto.getSensores();
    }
     
   /**
   * Devuelve un List<Sensor> con los objetos de la clase Sensor y estado "Sin-Asignar"
   * @return 
   */
     public List<Sensor> getSensoresDisponibles(){
        return experto.getSensoresDisponibles();
    }
     
     public Sensor getSensor(int numero){
     
         return experto.getSensor(numero);
     }
     
     public boolean Modificar_Sensor(String numero, String modelo_sensor, String nro_serie){
         return experto.Modificar_Sensor(numero, modelo_sensor, nro_serie);
     }
     public Estado_Sensor getEstado_Sensor(String estado){
         return experto.getEstado_Sensor(estado);
     }
     public boolean Modificar_Estado_Sensor(String numero, String estado){
          return experto.Modificar_Estado_Sensor(numero, estado);
     }
}
