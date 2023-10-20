package dao;

import register.Loans;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoansDAO {
    private EntityManager em;

    public LoansDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loans prestito) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            System.out.println(prestito);
            em.persist(prestito);
            transaction.commit();
            System.out.println("Nuovo prestito salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Loans findById(int id) {
        return em.find(Loans.class, id);
    }

    public void delete(int id) {
        Loans loanFounded = em.find(Loans.class, id);
        try {
            if (loanFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(loanFounded);
                transaction.commit();
                System.out.println("il prestito è stato cancellato correttamente");
            } else {
                System.err.println("il prestito non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
