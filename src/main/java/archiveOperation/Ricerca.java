package archiveOperation;

import catalog.Book;
import catalog.Material;
import dao.MaterialDAO;

import javax.persistence.TypedQuery;
import java.util.InputMismatchException;
import java.util.List;

import static coso.Application.em;
import static other.Tools.input;

//query = "SELECT b FROM BlogPost b WHERE LOWER(b.title) LIKE LOWER(CONCAT(:title, '%'))"))
public class Ricerca {
    public static void ricerca() {
        MaterialDAO matDAO = new MaterialDAO(em);
        try {
            System.out.println("come vuoi ricercare ? isbn , anno , autore o titolo  ");
            String researchFromUser = input.nextLine().toLowerCase().trim();
            switch (researchFromUser) {
                case "isbn": {
                    System.out.println("inserire isbm da ricercare ");
                    Material libroIsbn = matDAO.findById(input.nextInt());
                    System.out.println(libroIsbn);
                    break;
                }
                case "anno": {
                    System.out.println("inserire anno da ricercare ");
                    int reseachYear = input.nextInt();
                    List<Material> libriPerAnno = filterYear(reseachYear);
                    libriPerAnno.forEach(System.out::println);
                    break;
                }

                case "autore": {
                    System.out.println("inserire autore da ricercare ");
                    String reseachAuthor = input.nextLine();
                    List<Book> libriPerAutore = filterAuthor(reseachAuthor);
                    libriPerAutore.forEach(System.out::println);
                    break;
                }

                case "titolo": {
                    System.out.println("inserire autore da ricercare ");
                    String reseachTitle = input.nextLine();
                    List<Material> libriPerTitoli = filterTitles(reseachTitle);
                    libriPerTitoli.forEach(System.out::println);
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


    public static List<Material> filterYear(int anno) {
        TypedQuery<Material> getAllQuery = em.createQuery("SELECT m FROM Material m WHERE m.annoDiPubblicazione = :anno", Material.class);
        getAllQuery.setParameter("anno", anno);
        return getAllQuery.getResultList();
    }

    public static List<Book> filterAuthor(String author) {
        TypedQuery<Book> getAllQuery = em.createQuery("SELECT m FROM Material m WHERE LOWER(m.autore) LIKE LOWER(CONCAT(:author , '%'))", Book.class);
        getAllQuery.setParameter("author", author);
        return getAllQuery.getResultList();
    }

    public static List<Material> filterTitles(String title) {
        TypedQuery<Material> getAllQuery = em.createQuery("SELECT m FROM Material m WHERE LOWER(m.titolo) LIKE LOWER(CONCAT(:title , '%'))", Material.class);
        getAllQuery.setParameter("title", title);
        return getAllQuery.getResultList();
    }

}
