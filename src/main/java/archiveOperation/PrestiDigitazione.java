package archiveOperation;

import dao.MaterialDAO;
import dao.UserDAO;
import register.Loans;
import register.User;

import javax.persistence.TypedQuery;
import java.util.InputMismatchException;
import java.util.List;

import static coso.Application.em;
import static other.Tools.input;

public class PrestiDigitazione {
    public static void prestiti() {
        UserDAO userDao = new UserDAO(em);
        MaterialDAO matDAO = new MaterialDAO(em);
        try {
            System.out.println("prestiti attuali");
            allLoans().forEach(System.out::println);
            System.out.println("come vuoi filtrare ? utente o scaduti");
            String loansFromUser = input.nextLine().toLowerCase().trim();
            switch (loansFromUser) {
                case "utente": {
                    System.out.println("inserisci id utente");
                    int searchedUserId = input.nextInt();
                    User prestitoSearcher = userDao.findById(searchedUserId);
                    System.out.println(prestitoSearcher.getLoans());
                    break;
                }
                case "scaduti": {
                    List<Loans> deprecatedLoans = deprecatedLoans();
                    deprecatedLoans.forEach(System.out::println);
                    break;

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

    public static List<Loans> deprecatedLoans() {
        TypedQuery<Loans> getAllQuery = em.createQuery("SELECT l FROM Loans l WHERE l.effetiva > l.fine", Loans.class);
        return getAllQuery.getResultList();
    }


}
