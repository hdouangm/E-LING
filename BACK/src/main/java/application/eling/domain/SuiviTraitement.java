package application.eling.domain;

import javax.persistence.*;
import java.io.Serializable;

import static application.eling.domain.SuiviTraitement.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM SuiviTraitement b ORDER BY b.id DESC")
public class SuiviTraitement implements Serializable {
    public static final String FIND_ALL = "SuiviTraitement.findAllSuiviTraitements";

    @Id
    @GeneratedValue
    private Integer id;
    private String date;
    private Boolean priseTraitement;
    private Employe infirmiere;
    @ManyToOne(cascade = CascadeType.ALL)
    private Posologie posologie;

    public SuiviTraitement() {

    }

    public SuiviTraitement(String date, Boolean priseTraitement, Employe infirmiere) {
        this.date = date;
        this.priseTraitement = priseTraitement;
        this.infirmiere = infirmiere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPriseTraitement() {
        return priseTraitement;
    }

    public void setPriseTraitement(Boolean priseTraitement) {
        this.priseTraitement = priseTraitement;
    }

    public Employe getInfirmiere() {
        return infirmiere;
    }

    public void setInfirmiere(Employe infirmiere) {
        this.infirmiere = infirmiere;
    }

    public Posologie getPosologie() {
        return posologie;
    }

    public void setPosologie(Posologie posologie) {
        this.posologie = posologie;
    }

    @Override
    public String toString() {
        return "SuiviTraitement{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", priseTraitement=" + priseTraitement +
                ", infirmiere=" + infirmiere +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SuiviTraitement other = (SuiviTraitement) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (priseTraitement == null) {
            if (other.priseTraitement != null)
                return false;
        } else if (!priseTraitement.equals(other.priseTraitement))
            return false;
        return true;
    }
}