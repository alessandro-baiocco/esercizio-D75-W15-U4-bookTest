package catalog;

import javax.persistence.Entity;

@Entity
public class Book extends Material {


    private String autore;
    private int annoDiPubblicazione;


    //costruttore
    public Book() {
    }

    public Book(String titolo, int annoDiPubblicazione, int numeroPagine, String autore, int annoDiPubblicazione1) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.annoDiPubblicazione = annoDiPubblicazione1;
    }

    public String getAutore() {
        return autore.toLowerCase().trim();
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }


    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autore='" + autore + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                "} " + super.toString();
    }
}
