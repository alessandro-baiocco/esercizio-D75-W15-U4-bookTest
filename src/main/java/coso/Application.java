package coso;

import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    private static final EntityManagerFactory emf = JPAutil.emfCreate();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

//        try {
//            SalvaOCarica.primoCaricamento();
//            esterno:
//            while (true) {
//                System.out.println("1 : per aggiungere o rimuovere");
//                System.out.println("2 : per ricercare");
//                System.out.println("3 : per salvare o ricaricare");
//                System.out.println("4 : per vedere l'archivio");
//                System.out.println("5 : per uscire");
//                String userInputStr = input.nextLine();
//                switch (userInputStr) {
//                    case "1": {
//                        AggiungiOrimuovi.operazione();
//                        break;
//                    }
//                    case "2": {
//                        Ricerca.ricerca();
//                        break;
//                    }
//                    case "3": {
//                        SalvaOCarica.salvaOcarica();
//                        break;
//                    }
//                    case "4": {
//                        System.out.println(catalogo);
//                        break;
//                    }
//                    case "5": {
//                        System.out.println("uscita");
//                        break esterno;
//                    }
//                    default: {
//                        System.out.println("eh? cosa ?");
//                    }
//
//                }
//            }
//        } catch (InputMismatchException | NumberFormatException ex) {
//            System.err.println("input non valido");
//        } catch (Exception ex) {
//            System.err.println("errore generico");
//            System.out.println(ex.getMessage());
//        } finally {
//            input.close();
//        }
    }


}

