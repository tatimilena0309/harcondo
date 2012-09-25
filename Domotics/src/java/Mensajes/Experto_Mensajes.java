/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensajes;

import Experto.Experto;
import Negocio.Mensaje;
import Negocio.Tipo_Mensaje;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Fachada_Persistencia;

/**
 *
 * @author LEO
 */
public class Experto_Mensajes extends Experto{
    
    /**
     * Este metodo crea un objeto de la clase mensaje con los parametros indicado y lo devuelve,
     * no lo persiste para evitar mensajes sin ambiente asignado
     * @param nombre
     * @param descripcion
     * @param tipo
     * @return 
     */ 
    public Mensaje crearMensaje(String nombre, String descripcion, String tipo){
        
        Mensaje mensaje = new Mensaje();
        mensaje.setNombre(nombre);
        mensaje.setDescripcion(descripcion);
        mensaje.setTipo_mensaje(this.getTipoMensaje(tipo));
        return mensaje;
    
    }
    
    /**
     * Este metodo devuelve el tipo mensaje con nombre indicado por el parametro.
     * Si no existe lo crea
     * @param tipo
     * @return 
     */
    public Tipo_Mensaje getTipoMensaje(String tipo){
        
          try{
        //Buscamos el Estado_Ambiente con el nombre indicado
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        Query q = (Query) em.createQuery("SELECT  FROM Tipo_Mensaje t where t.nombre=:nombre");
        q.setParameter("nombre", tipo);
        Tipo_Mensaje tipo_mensaje = (Tipo_Mensaje) q.getSingleResult();

        return tipo_mensaje;
        }
     catch(Exception e){
         // Si no encontro el estado ambiente lo genera y lo devuelve
         Tipo_Mensaje tipo_mensaje  = new Tipo_Mensaje();
         tipo_mensaje.setNombre(tipo);
         try {
            Fachada_Persistencia.getInstance().guardar(tipo_mensaje);
            return tipo_mensaje;
         }catch(Exception ex){
            return null;
         }
     }
        
    }
}
