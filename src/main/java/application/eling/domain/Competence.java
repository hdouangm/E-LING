package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.Competence.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Competence b ORDER BY b.id DESC")
public class Competence {
    public static final String FIND_ALL = "Competence.findAllCompetences";
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    public Competence() {

    }

    public Competence(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}