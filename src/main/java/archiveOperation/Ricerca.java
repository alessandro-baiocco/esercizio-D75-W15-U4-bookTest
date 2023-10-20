package archiveOperation;

import java.util.InputMismatchException;

import static other.Tools.input;

public class Ricerca {
    public static void ricerca() {
        try {
            System.out.println("come vuoi ricercare ? isbn , anno o autore ");
            String researchFromUser = input.nextLine().toLowerCase().trim();
            switch (researchFromUser) {
                case "isbn": {
                    System.out.println("inserire isbm da ricercare ");

                    break;
                }
                case "anno": {

                    break;
                }
                case "autore": {

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

}
