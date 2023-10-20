package coso;

import archiveOperation.AggiungiOrimuovi;
import archiveOperation.PrestiDigitazione;
import archiveOperation.Ricerca;
import catalog.Book;
import catalog.Magazine;
import catalog.Material;
import dao.LoansDAO;
import dao.MaterialDAO;
import dao.UserDAO;
import register.Loans;
import register.User;
import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.function.Supplier;

import static other.Tools.*;


public class Application {

    public static final EntityManagerFactory emf = JPAutil.emfCreate();
    public static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
//        LocalDate dateOfBirth = now.minusYears(rnd.nextInt(25 , 70));
//        Date date2 = "1995-01-01";

        MaterialDAO matDAO = new MaterialDAO(em);
        UserDAO userDao = new UserDAO(em);
        LoansDAO loanDao = new LoansDAO(em);


        Supplier<Book> bookSupplier = () -> {
            return new Book(faker.book().title(), rnd.nextInt(1950, 2023), rnd.nextInt(50, 500), faker.book().author(), faker.book().genre());
        };
        Supplier<Magazine> magazineSupplier = () -> {
            return new Magazine(faker.book().title(), rnd.nextInt(1950, 2023), rnd.nextInt(50, 500), rndPerdiodo[rnd.nextInt(0, 2)]);
        };
        Supplier<User> userSupplier = () -> {
            return new User(faker.name().firstName(), faker.name().lastName(), now.minusYears(rnd.nextInt(25, 70)));
        };
        Supplier<Loans> loansSupplier = () -> {
            return new Loans(matDAO.findById(rnd.nextInt(713, 731)), userDao.findById(rnd.nextInt(693, 711)), now.minusWeeks(rnd.nextInt(25, 70)), now.plusDays(rnd.nextInt(0, 70)));
        };

//
//        for (int i = 0; i < 20; i++) {
//            userDao.save(userSupplier.get());
//        }

//
//        for (int i = 0; i < 10; i++) {
//            loanDao.save(loansSupplier.get());
//        }

//
//        for (int i = 0; i < 10; i++) {
//            matDAO.save(bookSupplier.get());
//            matDAO.save(magazineSupplier.get());
//        }


        try {
            esterno:
            while (true) {
                System.out.println("1 : per aggiungere o rimuovere");
                System.out.println("2 : per ricercare");
                System.out.println("3 : per vedere i prestiti");
                System.out.println("4 : per vedere l'archivio");
                System.out.println("5 : per uscire");
                String userInputStr = input.nextLine();
                switch (userInputStr) {
                    case "1": {
                        AggiungiOrimuovi.operazione();
                        break;
                    }
                    case "2": {
                        Ricerca.ricerca();
                        break;
                    }
                    case "3": {
                        PrestiDigitazione.prestiti();
                        break;
                    }
                    case "4": {
                        catalogo().forEach(System.out::println);
                        break;
                    }
                    case "5": {
                        System.out.println("uscita");
                        break esterno;
                    }
                    default: {
                        System.out.println("eh? cosa ?");
                    }

                }
            }
        } catch (InputMismatchException | NumberFormatException ex) {
            System.err.println("input non valido");
        } catch (Exception ex) {
            System.err.println("errore generico");
            System.out.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }

    public static List<Material> catalogo() {
        TypedQuery<Material> getAllQuery = em.createQuery("SELECT M FROM Material M", Material.class);
        return getAllQuery.getResultList();
    }


}


