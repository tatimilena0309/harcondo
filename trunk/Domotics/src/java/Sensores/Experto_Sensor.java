/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensores;

import Negocio.Modelo_Sensor;
import Negocio.Sensor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Fachada_Persistencia;

/**
 *
 * @author LEO
 */
public class Experto_Sensor {
    
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
     * Este metodo da de alta a un sensor
     * @param numero
     * @param numero_serie
     * @param Modelo
     * @return
     */
  public Sensor Alta_Sensor(int numero, String numero_serie, String Modelo){

        Sensor sensor = new Sensor();
        sensor.setFecha_alta(new Date());
        sensor.setFecha_ultima_modificacion(new Date());
        sensor.setNumero(numero);
        sensor.setNumero_serie(numero_serie);

        return null;
    }
  /**
   * Este metodo devuelve null si no encuentra Modelo_Sensor con el nombre indicado
   * Si lo encuentra devuelve un objeto Modelo_Sensor
   * @param nombre
   * @return
   */
  public Modelo_Sensor getModelo_Sensor(String nombre){
       //Buscamos el modelo de sensor con el nombre indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT m FROM Modelo_Sensor m where m.nombre=:nombre");
        q.setParameter("nombre", nombre);
        Modelo_Sensor modelo = (Modelo_Sensor) q.getSingleResult(); 


      
        return null;
  }
    
}
