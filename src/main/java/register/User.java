package register;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int nTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    @OneToOne
    @JoinTable(name = "loans",
            joinColumns = @JoinColumn(name = "user_nTessera"))
    private Loans prestito;

    public User() {
    }

    public User(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Loans getLoans() {
        return prestito;
    }

    public void setLoans(Loans loans) {
        this.prestito = loans;
    }

    public int getnTessera() {
        return nTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

}

