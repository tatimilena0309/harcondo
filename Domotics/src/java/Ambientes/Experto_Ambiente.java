/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Experto.Experto;
import Negocio.Ambiente;
import Negocio.Mensaje;
import Negocio.Sensor;
import Sensores.Controlador_Sensor;
import java.lang.Class;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
  public Ambiente Alta_Ambiente(String nombre, String descripcion, String nro_sensor, String mensaje, String actualizacion){

        try{
        
        Ambiente ambiente = new Ambiente();
        
        ambiente.setNombre(nombre);
        ambiente.setDescripcion(descripcion);
        
        Controlador_Sensor contr = new Controlador_Sensor();
        Sensor sensor = contr.getSensor(Integer.parseInt(nro_sensor));
        ambiente.setSensor(sensor);

        // Hora de actualizacion en minutos
        ambiente.setHora_actualizacion(Integer.parseInt(actualizacion));
        //seteamos fechas
        ambiente.setFecha_alta(new Date());
        ambiente.setFecha_ultima_modificacion(new Date());
        ambiente.setHora_ultimo_acceso(new Date());

        //Falta setear el mensaje
        Mensaje mensj = new Mensaje();
            //Al nombre del mensaje le llamamos el mismo nombre del ambiente
            mensj.setNombre(nombre);
            mensj.setDescripcion(mensaje);
        ambiente.setMensaje(mensj);



        Fachada_Persistencia.getInstance().guardar(mensj);
        Fachada_Persistencia.getInstance().guardar(ambiente);
        
        return ambiente;
      } catch (Exception e){
        // poner accion
        System.out.println("Error metodo Alta_Ambiente. Detalle:  " + e.getMessage());
        return null;
      }

    }


    /**
   * Devuelve un List con los objetos de la clase Ambiente
   * @return
   */

  public List<Ambiente> getAmbientes(){

      //Buscamos los sensores de la base de datos y los devolvemos
      return Fachada_Persistencia.getInstance().getListaObjetos("Ambiente");


  }


  public Ambiente getAmbiente(String nombre){
      try{

      //Buscamos el sensor con el numero indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT a FROM Ambiente a where a.nombre=:nombre");
        q.setParameter("nombre", nombre);
        Ambiente ambiente = (Ambiente) q.getSingleResult();

        return ambiente;
        }
     catch(Exception e){
         // Poner Accion
         return null;
     }
  }

   public boolean Modificar_Ambiente(Long id, String nombre, String descripcion, String nro_sensor, String mensaje, String hora_actualizacion) {
      try {
       // traemos el ambiente
       Ambiente ambiente = (Ambiente) Fachada_Persistencia.getInstance().getObjeto_ID(id, "Ambiente");

       ambiente.setNombre(nombre);
       ambiente.setDescripcion(descripcion);
       // si el sensor es distinto busca el sensor a actualizar y lo asocia a la clase
       if(ambiente.getSensor().getNumero() != Integer.parseInt(nro_sensor)){
            Controlador_Sensor contr = new Controlador_Sensor();
            Sensor sensor = contr.getSensor(Integer.parseInt(nro_sensor));
            ambiente.setSensor(sensor);
       }

        // si el Mensaje es distinto busca el Mensaje a actualizar y lo actualiza
       if (!ambiente.getMensaje().getDescripcion().equals(mensaje)){
            ambiente.getMensaje().setDescripcion(mensaje);

                Fachada_Persistencia.getInstance().guardar(ambiente.getMensaje());

       }

       ambiente.setHora_actualizacion(Integer.parseInt(hora_actualizacion));
       ambiente.setFecha_ultima_modificacion(new Date());

       Fachada_Persistencia.getInstance().guardar(ambiente);
       return true;
       } catch (Exception ex) {
                System.out.println("Error metodo Modificar Ambiente:  " + ex.getMessage());
       }
       return false;
    }
  
  
    
    
    
}
