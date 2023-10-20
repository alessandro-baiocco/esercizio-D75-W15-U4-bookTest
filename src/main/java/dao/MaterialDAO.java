package dao;

import catalog.Magazine;
import catalog.Material;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MaterialDAO {
    private EntityManager em;

    public MaterialDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Material mat) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(mat);
            transaction.commit();
            System.out.println("Nuovo libro salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Material findById(int id) {
        return em.find(Material.class, id);
    }

    public void delete(int id) {
        Material matFounded = em.find(Magazine.class, id);
        try {
            if (matFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(matFounded);
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
