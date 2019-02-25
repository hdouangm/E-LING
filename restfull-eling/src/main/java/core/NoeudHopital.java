package main.java.core;

import javax.persistence.*;

import java.util.List;


public class NoeudHopital {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";

    private Integer id;
    private Integer niveau;
    private List<NoeudHopital> noeudsInferieurs;
    private Employe chef;

    public NoeudHopital(){

    }

    public NoeudHopital(Integer niveau, List<NoeudHopital> noeudsInferieurs, Employe chef) {
        this.niveau = niveau;
        this.noeudsInferieurs = noeudsInferieurs;
        this.chef = chef;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public List<NoeudHopital> getNoeudsInferieurs() {
        return noeudsInferieurs;
    }

    public void setNoeudsInferieurs(List<NoeudHopital> noeudsInferieurs) {
        this.noeudsInferieurs = noeudsInferieurs;
    }

    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "NoeudHopital{" +
                "id=" + id +
                ", niveau=" + niveau +
                ", noeudsInferieurs=" + noeudsInferieurs +
                ", chef=" + chef +
                '}';
    }
}
