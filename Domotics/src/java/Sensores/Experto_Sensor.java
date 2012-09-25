/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensores;

import Experto.Experto;
import Negocio.Estado_Sensor;
import Negocio.Modelo_Sensor;
import Negocio.Sensor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Fachada_Persistencia;
import persistencia.ObjetoPersistente;

/**
 *
 * @author LEO
 */
public class Experto_Sensor extends Experto{

    /**
     * Este metodo devuelve todos los Modelos de sensores cargados en la base de datos,
     * Si no existe ninguno crea un modelo generico
     * @return 
     */
    public List<Modelo_Sensor> getModelosSensores(){
        List<Modelo_Sensor> modelos = new ArrayList();
        try{
            //Buscamos todos los modelos sensor de la BD y los devolvemos
            EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
            Query q = (Query) em.createQuery("SELECT m FROM Modelo_Sensor m");
            modelos = q.getResultList();
            if (modelos.isEmpty()){
            //Si no existe un modelo sensor creamos uno generico.
            Modelo_Sensor modelo = new Modelo_Sensor();
            modelo.setModelo("Modelo Generico");
            modelo.setCaptacion_horizontal(0);
            modelo.setCaptacion_vertical(0);
            modelo.setDistancia_deteccion_max(0);
            modelo.setMarca("Marca Generica");

            /* Falta crear tipo de sensor
             * modelo.setTipo_sensor("generico");
             */


            //persistimos

            em.getTransaction().begin();
            em.persist(modelo);
            em.flush();
            em.getTransaction().commit();

            modelos.add(modelo);
            }

        }
        catch(Exception e){
        // falta poner accion



        }


        return modelos;
    }

    /**
     * Este metodo da de alta a un sensor. Si se da de alta de forma correcta
     * devuelve el nuevo sensor creado. Le asigna a este sensor el estado 
     * @param numero
     * @param numero_serie
     * @param Modelo
     * @return
     */
  public Sensor Alta_Sensor(int numero, String numero_serie, String Modelo){

        try{
        Sensor sensor = new Sensor();
        sensor.setFecha_alta(new Date());
        sensor.setFecha_ultima_modificacion(new Date());
        sensor.setNumero(numero);
        sensor.setNumero_serie(numero_serie);
        sensor.setModelo_sensor(this.getModelo_Sensor(Modelo));
        sensor.setEstado_sensor(this.getEstado_Sensor("Sin_Asignar"));
        Fachada_Persistencia.getInstance().guardar(sensor);
        
        return sensor;
      } catch (Exception e){
        // poner accion
        return null;
      }

    }
  /**
   * Este metodo devuelve null si no encuentra Modelo_Sensor con el nombre indicado
   * Si lo encuentra devuelve un objeto Modelo_Sensor
   * @param nombre
   * @return
   */
  public Estado_Sensor getEstado_Sensor(String estado){
     try{

      //Buscamos el estado sensor con el nombre indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT e FROM Estado_Sensor e where e.nombre=:estado");
        q.setParameter("estado", estado);
       
        Estado_Sensor estadoSensor = (Estado_Sensor) q.getSingleResult();

        return estadoSensor;
        }
     catch(Exception e){
         // Si no encuentra el estado sensor lo crea
          Estado_Sensor estadoSensor = new Estado_Sensor();
          estadoSensor.setNombre(estado);
          estadoSensor.setDescripcion("El estado del sensor es " + estado);
          try{
            Fachada_Persistencia.getInstance().guardar(estadoSensor);
            return estadoSensor;
          }catch(Exception ex){
              return null;
          }
         
     }
  }
  
  
  /**
   * Este metodo devuelve un objeto Estado_Sensor con el nombre indicado
   * Si no lo encuentra lo crea
   * @param nombre
   * @return
   */
  public Modelo_Sensor getModelo_Sensor(String modelo){
     try{

      //Buscamos el modelo de sensor con el nombre indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT m FROM Modelo_Sensor m where m.modelo=:modelo");
        q.setParameter("modelo", modelo);
        Modelo_Sensor mod = (Modelo_Sensor) q.getSingleResult();

        return mod;
        }
     catch(Exception e){
         // Poner Accion
         return null;
     }
  }
  
  
  /**
   * Devuelve un List con los objetos de la clase Sensor
   * @return 
   */
  
  public List<Sensor> getSensores(){
  
      //Buscamos los sensores de la base de datos y los devolvemos
      return Fachada_Persistencia.getInstance().getListaObjetos("Sensor");
      
      
  }
  
   /**
   * Devuelve un List con los objetos de la clase Sensor con estado "Sin_Asignar"
   * @return 
   */
  
  public List<Sensor> getSensoresDisponibles(){
  
      //Buscamos los sensores con estado_sensor "Sin_Asignar" y los devolvemos
      
      EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
      Query q = em.createQuery("Select s FROM Sensor s WHERE s.estado_sensor.nombre = 'Sin_Asignar'");
      return q.getResultList();
      
      
      
  }
  
  
  
  public Sensor getSensor(int numero){
      try{

      //Buscamos el sensor con el numero indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT s FROM Sensor s where s.numero=:numero");
        q.setParameter("numero", numero);
        Sensor sensor = (Sensor) q.getSingleResult();

        return sensor;
        }
     catch(Exception e){
         // Poner Accion
         return null;
     }
  }
  
  /**
   * Actualiza el sensor con los parametros indicados
   * @param numero
   * @param modelo_sensor
   * @param nro_serie
   * @return 
   */
  public boolean Modificar_Sensor(String numero, String modelo_sensor, String nro_serie){
         Sensor sensor = this.getSensor(Integer.parseInt(numero));
         sensor.setNumero_serie(nro_serie);
            
         //Si el modelo de sensor es distinto al actual lo busca y modifica sino no
            if (!sensor.getModelo_sensor().getModelo().equals(modelo_sensor)){
                sensor.setModelo_sensor(this.getModelo_Sensor(modelo_sensor));
            }
         
         try{
             Fachada_Persistencia.getInstance().guardar(sensor);
             return true;
         }catch(Exception e){
             return false;
         }
         
     }
  
  /**
   * Actualiza el estado del sensor con los parametros indicados
   * @param numero
   * @param estado
   * @return 
   */
  public boolean Modificar_Estado_Sensor(String numero, String estado){
         Sensor sensor = this.getSensor(Integer.parseInt(numero));
        
         //Si el estado del sensor es distinto al actual lo busca y modifica sino no
            if (!sensor.getEstado_sensor().getNombre().equals(estado)){
                sensor.setEstado_sensor(this.getEstado_Sensor(estado));
                try{
                    Fachada_Persistencia.getInstance().guardar(sensor);
                    return true;
                }catch(Exception e){
                    return false;
                }
            
            }
         
         return true;
         
     }
  

}
