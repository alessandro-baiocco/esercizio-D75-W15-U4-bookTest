package dao;

import catalog.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookDAO {
    private EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Book bk) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(bk);
            transaction.commit();
            System.out.println("Nuovo libro salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Book findById(long id) {
        return em.find(Book.class, id);
    }

    public void delete(long id) {
        Book bookFounded = em.find(Book.class, id);
        try {
            if (bookFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(bookFounded);
                transaction.commit();
                System.out.println("il libro è stato cancellato correttamente");
            } else {
                System.err.println("il libro non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}