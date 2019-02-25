package main.java.core;

import javax.persistence.*;

import java.util.Set;


public class Posologie {
    public static final String FIND_ALL = "Posologie.findAllPosologies";

    private Integer id;
    private DMP dmp;
    private String posologie;
    private Set<String> suiviTraitement;
    private Employe responsable;
    private Boolean publication;
    private Set<Acte> codesActes;
    private Integer prix;
    private Boolean payer;

    public Posologie(){

    }

    public Posologie(DMP dmp, String posologie, Set<String> suiviTraitement, Employe responsable, Boolean publication, Set<Acte> codesActes, Integer prix, Boolean payer) {
        this.dmp = dmp;
        this.posologie = posologie;
        this.suiviTraitement = suiviTraitement;
        this.responsable = responsable;
        this.publication = publication;
        this.codesActes = codesActes;
        this.prix = prix;
        this.payer = payer;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public Set<String> getSuiviTraitement() {
        return suiviTraitement;
    }

    public void setSuiviTraitement(Set<String> suiviTraitement) {
        this.suiviTraitement = suiviTraitement;
    }

    public Employe getResponsable() {
        return responsable;
    }

    public void setResponsable(Employe responsable) {
        this.responsable = responsable;
    }

    public Boolean getPublication() {
        return publication;
    }

    public void setPublication(Boolean publication) {
        this.publication = publication;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Set<Acte> getCodesActes() {
        return codesActes;
    }

    public void setCodesActes(Set<Acte> codesActes) {
        this.codesActes = codesActes;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Boolean getPayer() {
        return payer;
    }

    public void setPayer(Boolean payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "Posologie{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", posologie='" + posologie + '\'' +
                ", suiviTraitement=" + suiviTraitement +
                ", responsable=" + responsable +
                ", publication=" + publication +
                ", codesActes=" + codesActes +
                ", prix=" + prix +
                ", payer=" + payer +
                '}';
    }
}
