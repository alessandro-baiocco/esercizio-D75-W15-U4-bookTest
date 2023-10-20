package catalog;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Book extends Material {


    private String autore;
    private String genere;


    //costruttore
    public Book() {
    }

    public Book(String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore.toLowerCase().trim();
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }


    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autore='" + autore + '\'' +
                ", annoDiPubblicazione=" + genere +
                "} " + super.toString();
    }
}
