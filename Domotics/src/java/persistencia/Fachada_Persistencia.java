/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leo
 */
public class Fachada_Persistencia {
    
    public static Fachada_Persistencia instance = new Fachada_Persistencia();
    

    public static Fachada_Persistencia getInstance()
    {
    return instance;

    }


    public EntityManager getEntityManager (){
        String UNIDAD_DE_PERSISTENCIA = "DomoticsPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
        EntityManager em = factory.createEntityManager();
        return em;
    }

    /**
     * Este metodo persiste o actualiza el objeto pasado como parametro
     * @param obj
     * @throws Exception
     */
    public void guardar(ObjetoPersistente obj) throws Exception{
        
        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        em.getTransaction().begin();
        
        if(obj.getId() != null){
            em.merge(obj);
        }else{
            em.persist(obj);
        }
        em.flush();
        em.getTransaction().commit();
    }
}
