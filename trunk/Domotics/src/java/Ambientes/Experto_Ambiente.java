/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambientes;

import Experto.Experto;
import Negocio.Ambiente;
import Negocio.Estado_Ambiente;
import Negocio.Mensaje;
import Negocio.Sensor;
import Sensores.Controlador_Sensor;
import java.lang.Class;
import java.util.ArrayList;
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
       * Este metodo da de alta a un Ambiente con estado Activo. Si se da de alta de forma correcta
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

        //Seteamos el estado
        Estado_Ambiente estado = this.getEstado_Ambiente("Activo");
        ambiente.setEstado_ambiente(estado);



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
   * Este metodo devuelve un objeto de la clase Estado_Ambiente con el nombre indicado por parametro.
   * Si el estado no existe lo crea, lo persiste y lo devuelve.
   * @param estado
   * @return
   */
  public Estado_Ambiente getEstado_Ambiente(String estado){


      try{
        //Buscamos el Estado_Ambiente con el nombre indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT a FROM Estado_Ambiente a where a.nombre=:nombre");
        q.setParameter("nombre", estado);
        Estado_Ambiente estado_ambiente = (Estado_Ambiente) q.getSingleResult();

        return estado_ambiente;
        }
     catch(Exception e){
         // Si no encontro el estado ambiente lo genera y lo devuelve
         Estado_Ambiente estado_ambiente = new Estado_Ambiente();
         estado_ambiente.setNombre(estado);
         try {
            Fachada_Persistencia.getInstance().guardar(estado_ambiente);
            return estado_ambiente;
         }catch(Exception ex){
            return null;
         }
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


  /**
   * Este metodo devuelve el objeto de la clase ambiente con nombre igual al pasado por parametro
   * @param nombre
   * @return
   */
  public Ambiente getAmbiente(String nombre){
      try{

      //Buscamos el Ambiente con el nombre indicado
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

  /**
   * Este metodo modifica un objeto ambiente con id indicado y le asiga los valores pasados por parametro
   * @param id
   * @param nombre
   * @param descripcion
   * @param nro_sensor
   * @param mensaje
   * @param hora_actualizacion
   * @return
   */
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
  

  /**
   * Este metodo devuelve todos los estados ambientes del sistema, Si no esxisten los crea
   * por el metodo getEstado_Ambiente();
   * @return
   */

  public List<Estado_Ambiente> getEstados_Ambiente(){

        List<Estado_Ambiente> estados = new ArrayList();
            //Asignamos los estados de esta manera para asegurarnos que se crean todos
        estados.add(this.getEstado_Ambiente("Activo"));
        estados.add(this.getEstado_Ambiente("Baja"));

        //estados.add(this.getEstado_Ambiente("Inactivo")); //(Este va en una iteracion proxima)
        return estados;
  }


   /**
    * Este Metodo asigna el estado con nombre "nombre_estado" al ambiente con id "id".
    * Si el metodo falla devuelve false, sino devuelve true.
    * @param id
    * @param nombre_estado
    * @return
    */
   public boolean Modificar_Estado_Ambiente(Long id, String nombre_estado){
        try{
        Ambiente ambiente = (Ambiente) Fachada_Persistencia.getInstance().getObjeto_ID(id, "Ambiente");
        ambiente.setEstado_ambiente(this.getEstado_Ambiente(nombre_estado));
        Fachada_Persistencia.getInstance().guardar(ambiente);
        return true;
        }catch(Exception e){
            //poner accion
        return false;
        }
      
  }

    
    
    
}
