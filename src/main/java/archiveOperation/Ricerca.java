package archiveOperation;

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
            System.out.println("come vuoi ricercare ? isbn , anno o autore ");
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
                    List<Material> libriPerAutore = filterAuthor(reseachAuthor);
                    libriPerAutore.forEach(System.out::println);
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

    public static List<Material> filterAuthor(String author) {
        TypedQuery<Material> getAllQuery = em.createQuery("SELECT m FROM Material m WHERE LOWER(m.autore) LIKE LOWER(CONCAT(:author , '%'))", Material.class);
        getAllQuery.setParameter("author", author);
        return getAllQuery.getResultList();
    }

}
