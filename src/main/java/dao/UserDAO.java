package dao;

import register.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
            System.out.println("Nuovo libro salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public User findById(long id) {
        return em.find(User.class, id);
    }

    public void delete(long id) {
        User userFounded = em.find(User.class, id);
        try {
            if (userFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(userFounded);
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