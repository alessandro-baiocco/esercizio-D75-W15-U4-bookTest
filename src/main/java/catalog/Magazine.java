package catalog;

import enums.Periodo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Magazine extends Material {

    @Enumerated(EnumType.STRING)
    private Periodo periodo;


    //costruttore
    public Magazine() {
    }

    public Magazine(String titolo, int annoDiPubblicazione, int numeroPagine, Periodo periodo) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodo = periodo;
    }


    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "periodo=" + periodo +
                "} " + super.toString();
    }


}
