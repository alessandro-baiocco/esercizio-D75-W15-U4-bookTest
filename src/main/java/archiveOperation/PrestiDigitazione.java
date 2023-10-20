package archiveOperation;

import dao.MaterialDAO;
import register.Loans;

import javax.persistence.TypedQuery;
import java.util.InputMismatchException;
import java.util.List;

import static coso.Application.em;
import static other.Tools.input;

public class PrestiDigitazione {
    public static void prestiti() {
        MaterialDAO matDAO = new MaterialDAO(em);
        try {
            System.out.println("prestiti attuali");
            allLoans().forEach(System.out::println);
            String loansFromUser = input.nextLine().toLowerCase().trim();
            switch (loansFromUser) {

                case "isbn": {

                }
                case "anno": {

                }

                default: {
                    System.out.println("eh? cosa ?");
                }
            }
        } catch (InputMismatchException | NumberFormatException ex) {
            System.err.println("input non valido");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }


    public static List<Loans> allLoans() {
        TypedQuery<Loans> getAllQuery = em.createQuery("SELECT l FROM Loans l", Loans.class);
        return getAllQuery.getResultList();
    }


}
