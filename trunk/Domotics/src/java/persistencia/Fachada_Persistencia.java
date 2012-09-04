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
}
