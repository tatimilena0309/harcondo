/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Experto.Experto;
import Negocio.Ambiente;
import Negocio.Sensor;
import Sensores.Controlador_Sensor;
import persistencia.Fachada_Persistencia;

/**
 *
 * @author eduardo
 */
public class Experto_Ambiente extends Experto{
    
    
      /**
       * Este metodo da de alta a un Ambiente. Si se da de alta de forma correcta
       * devuelve el nuevo Ambiente creado.
       * @param nombre
       * @param descripcion
       * @param nro_sensor
       * @param mensaje
       * @return 
       */
  public Ambiente Alta_Ambiente(String nombre, String descripcion, String nro_sensor, String mensaje){

        try{
        
        Ambiente ambiente = new Ambiente();
        
        ambiente.setNombre(nombre);
        ambiente.setDescripcion(descripcion);
        
        Controlador_Sensor contr = new Controlador_Sensor();
        Sensor sensor = contr.getSensor(Integer.getInteger(nro_sensor));
        ambiente.setSensor(sensor);
        
        //Falta setear el mensaje
        //ambiente.setMensaje(mensaje);
        
        Fachada_Persistencia.getInstance().guardar(ambiente);
        
        return ambiente;
      } catch (Exception e){
        // poner accion
        return null;
      }

    }
  
  
    
    
    
}
