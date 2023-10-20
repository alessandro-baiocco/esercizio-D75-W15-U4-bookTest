package register;

import catalog.Material;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Loans {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "prestito")
    private Material oggetto;

    private LocalDate inizio;
    private LocalDate fine;
    private LocalDate effetiva;

    @OneToOne(mappedBy = "prestito")
    private User utente;


    public Loans() {
    }

    public Loans(Material oggetto, User utente, LocalDate inizio, LocalDate effetiva) {
        this.oggetto = oggetto;
        this.utente = utente;
        this.inizio = inizio;
        this.fine = inizio.plusMonths(1);
        this.effetiva = effetiva;
    }

    public int getId() {
        return id;
    }

    public Material getOggetto() {
        return oggetto;
    }

    public void setOggetto(Material oggetto) {
        this.oggetto = oggetto;
    }

    public User getUtente() {
        return utente;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public LocalDate getEffetiva() {
        return effetiva;
    }

    public void setEffetiva(LocalDate effetiva) {
        this.effetiva = effetiva;
    }
}
