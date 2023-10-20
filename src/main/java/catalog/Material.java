package catalog;

import register.Loans;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "material_type")
public abstract class Material {
    @Id
    @GeneratedValue
    private int ISBN;


    private String titolo;
    private int annoDiPubblicazione;
    private int numeroPagine;

    @OneToOne(fetch = FetchType.LAZY)
    private Loans prestito;


    public Material() {
    }

    public Material(String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }


    @Override
    public String toString() {
        return "Material{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return ISBN == material.ISBN && annoDiPubblicazione == material.annoDiPubblicazione && numeroPagine == material.numeroPagine && Objects.equals(titolo, material.titolo);
    }


    public String save() {
        return "";
    }

}
