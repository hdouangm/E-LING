package main.java.core;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Competence {
    public static final String FIND_ALL = "Competence.findAllCompetences";

    private Integer id;
    private String description;

    public Competence() {

    }

    public Competence(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue
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