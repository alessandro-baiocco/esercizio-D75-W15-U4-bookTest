package dao;

import catalog.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MagDAO {
    private EntityManager em;

    public MagDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Magazine mag) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(mag);
            transaction.commit();
            System.out.println("Nuovo libro salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Magazine findById(long id) {
        return em.find(Magazine.class, id);
    }

    public void delete(long id) {
        Magazine magFounded = em.find(Magazine.class, id);
        try {
            if (magFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(magFounded);
                transaction.commit();
                System.out.println("la rivista è stato cancellato correttamente");
            } else {
                System.err.println("la rivista non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}
