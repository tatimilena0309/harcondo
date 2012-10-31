/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Negocio.Ambiente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Leo
 */
public class Fachada_Persistencia {

    public static Fachada_Persistencia instance = new Fachada_Persistencia();

    public static Fachada_Persistencia getInstance() {
        return instance;

    }

    public EntityManager getEntityManager() {
        String UNIDAD_DE_PERSISTENCIA = "DomoticsPU";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
        EntityManager em = factory.createEntityManager();
        return em;
    }

    /**
     * Este metodo persiste o actualiza el objeto pasado como parametro
     *
     * @param obj
     * @throws Exception
     */
    public void guardar(ObjetoPersistente obj) throws Exception {

        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        em.getTransaction().begin();

        if (obj.getId() != null) {
            em.merge(obj);
        } else {
            em.persist(obj);
        }
        em.flush();
        em.getTransaction().commit();
    }

    /**
     * Este metodo devuelve un List con todas los objetos de la clase indicada
     * en el parametro
     *
     * @param clase
     * @return
     */
    public List getListaObjetos(String clase) {

        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();

        return em.createQuery("Select o FROM " + clase + " o").getResultList();


    }

    

    /**
     * Este metodo devuelve el objeto de la clase indicada con el id indicado
     *
     * @param id
     * @param clase
     * @return
     */
    public ObjetoPersistente getObjeto_ID(Long id, String clase) {

        EntityManager em = Fachada_Persistencia.getInstance().getEntityManager();
        return (ObjetoPersistente) em.createQuery("Select o FROM " + clase + " o where o.id =" + id).getSingleResult();

    }

    
}
