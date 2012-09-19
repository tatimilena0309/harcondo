/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Controlador.Controlador;
import Fabricas.Fabrica_Expertos;
import Negocio.Ambiente;
import Negocio.Estado_Ambiente;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class Controlador_Ambiente extends Controlador{
    
    Experto_Ambiente experto;

    public Controlador_Ambiente() {
        
        experto = (Experto_Ambiente) Fabrica_Expertos.getInstancia().getExperto(Fabrica_Expertos.expertos.Ambiente);
        
    }

     public Ambiente Alta_Ambiente(String nombre, String descripcion, String nro_sensor, String mensaje, String actualizacion){
         return experto.Alta_Ambiente(nombre, descripcion, nro_sensor, mensaje, actualizacion);
     }
   
   /**
   * Devuelve un List con los objetos de la clase Ambiente
   * @return
   */

  public List<Ambiente> getAmbientes(){


      return experto.getAmbientes();


  }


  public Ambiente getAmbiente(String nombre){
     return experto.getAmbiente(nombre);
  }

  public boolean Modificar_Ambiente(Long id, String nombre, String descripcion, String nro_sensor, String mensaje, String hora_actualizacion){
    return experto.Modificar_Ambiente(id, nombre, descripcion, nro_sensor, mensaje, hora_actualizacion);
  }

  public List<Estado_Ambiente> getEstados_Ambiente(){
    return experto.getEstados_Ambiente();
  }

  public boolean Modificar_Estado_Ambiente(Long id, String nombre_estado){
    return experto.Modificar_Estado_Ambiente(id, nombre_estado);
  }
    
}
