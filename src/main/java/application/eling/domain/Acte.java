package application.eling.domain;

import javax.persistence.*;

import static application.eling.domain.Acte.FIND_ALL;
import static javax.persistence.CascadeType.ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Acte b ORDER BY b.id DESC")
public class Acte {
    public static final String FIND_ALL = "Acte.findAllActes";

    @OneToMany(cascade=ALL)
    private Integer id;
    private String description;
    private Integer prix;

    public Acte() {

    }

    public Acte(String description, Integer prix) {
        this.description = description;
        this.prix = prix;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Acte{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}

