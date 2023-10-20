package archiveOperation;

import catalog.Book;
import catalog.Magazine;
import dao.MaterialDAO;

import java.util.InputMismatchException;
import java.util.function.Supplier;

import static coso.Application.em;
import static other.Tools.*;

public class AggiungiOrimuovi {
    public static void operazione() {
        MaterialDAO matDAO = new MaterialDAO(em);


        Supplier<Book> bookSupplier = () -> {
            return new Book(faker.book().title(), rnd.nextInt(1950, 2023), rnd.nextInt(50, 500), faker.book().author(), faker.book().genre());
        };
        Supplier<Magazine> magazineSupplier = () -> {
            return new Magazine(faker.book().title(), rnd.nextInt(1950, 2023), rnd.nextInt(50, 500), rndPerdiodo[rnd.nextInt(0, 2)]);
        };


        try {
            System.out.println("vuoi aggiungere  un libro o una rivista o rimuovere qualcosa ? +book, +mag, -item  , random book o random mag ");
            String plusOminus = input.nextLine().trim().toLowerCase();
            switch (plusOminus) {
                case "+book": {
                    System.out.println("autore ?");
                    String autor = input.nextLine();
                    System.out.println("titoto ?");
                    String title = input.nextLine();
                    System.out.println("genere ?");
                    String gener = input.nextLine();
                    System.out.println("anno ?");
                    int year = Integer.parseInt(input.nextLine());
                    System.out.println("num pagine ?");
                    int pageNumber = Integer.parseInt(input.nextLine());
                    matDAO.save(new Book(title, year, pageNumber, autor, gener));
                    System.out.println("aggiunta di " + title + " avvenuta con successo");
                    break;
                }
                case "+mag": {
                    System.out.println("autore ?");
                    String autor = input.nextLine();
                    System.out.println("anno ?");
                    int year = Integer.parseInt(input.nextLine());
                    System.out.println("num pagine ?");
                    int pageNumber = Integer.parseInt(input.nextLine());
                    System.out.println("periodo ? 1 : settimanale , 2 : mensile , 3 : sequestrale , altro : sconosciuto ");
                    int perSel = Integer.parseInt(input.nextLine());
                    if (perSel > 3 || perSel < 1) perSel = 4;
                    matDAO.save(new Magazine(autor, year, pageNumber, rndPerdiodo[perSel]));
                    System.out.println("aggiunta della rivista avvenuta con successo");
                    break;
                }
                case "-item": {
                    System.out.println("numero ISMB ?");
                    int itemToRemove = Integer.parseInt(input.nextLine());
                    matDAO.delete(itemToRemove);
                    break;
                }
                case "random book": {
                    matDAO.save(bookSupplier.get());
                    break;
                }
                case "random mag": {
                    matDAO.save(magazineSupplier.get());
                    break;
                }
                default: {
                    System.out.println("eh ? cosa ? ");
                }
            }

        } catch (InputMismatchException | NumberFormatException ex) {
            System.err.println("input non valido");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("periodo non valido");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

