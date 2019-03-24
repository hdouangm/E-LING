/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.eling.domain;


import static application.eling.domain.DemandeExamen.FIND_ALL;
import static application.eling.domain.DemandeExamen.FIND_ALL_LAB;
import static application.eling.domain.DemandeExamen.FIND_ALL_MED;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ophedinho
 */


@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "SELECT dme FROM DemandeExamen dme ORDER BY dme.id DESC"),
        @NamedQuery(name = FIND_ALL_MED, query = "SELECT dme FROM DemandeExamen dme WHERE dme.publicationMed=0 ORDER BY dme.id DESC"),
        @NamedQuery(name = FIND_ALL_LAB, query = "SELECT dme FROM DemandeExamen dme WHERE dme.publicationLab=0 ORDER BY dme.id DESC")
})

//@NamedQuery(name = FIND_ALL, query = "SELECT dme FROM DemandeExamen dme ORDER BY dme.id DESC")

public class DemandeExamen {

    public static final String FIND_ALL = "DemandeExamen.findAll";
    public static final String FIND_ALL_MED = "DemandeExamen.findAllMed";
    public static final String FIND_ALL_LAB = "DemandeExamen.findAllLab";

    ////////////////////////////////////////////////
    ////////         Attributs           //////////
    //////////////////////////////////////////////

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Column(nullable = false)
    private int id_dmp;
    private int type_examen;
    private String date;
    private boolean publicationMed;
    private boolean publicationLab;
    private Boolean publierDemande;
    private Boolean demandeRemplie;
    @OneToOne(cascade = CascadeType.ALL)
    private DMP dmp;

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Boolean getPublierDemande() {
        return publierDemande;
    }

    public void setPublierDemande(Boolean publierDemande) {
        this.publierDemande = publierDemande;
    }

    public Boolean getDemandeRemplie() {
        return demandeRemplie;
    }

    public void setDemandeRemplie(Boolean demandeRemplie) {
        this.demandeRemplie = demandeRemplie;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Examen examen;
    ////////////////////////////////////////////////
    ////////         constructeurs       //////////
    //////////////////////////////////////////////



    public DemandeExamen(int id, int id_dmp, int type_examen, boolean publication, boolean publicationLab) {
        this.id = id;
        this.id_dmp = id_dmp;
        this.type_examen = type_examen;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = publicationLab;
    }

    public DemandeExamen(int id_dmp, int type_examen, boolean publication) {
        this.id_dmp = id_dmp;
        this.type_examen = type_examen;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = false;
    }

    public DemandeExamen(int id_dmp, int type_examen, boolean publication, boolean publicationLab) {
        this.id_dmp = id_dmp;
        this.type_examen = type_examen;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = publication;
        this.publicationLab = false;
    }

    public DemandeExamen() {
        this.id_dmp = 1;
        this.type_examen = 2;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(new java.util.Date(Calendar.getInstance().getTime().getTime()));
        this.publicationMed = true;
        this.publicationLab = false;
    }


    ////////////////////////////////////////////////
    ////////         M�thodes            //////////
    //////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public int getId_dmp() {
        return id_dmp;
    }


    public String getDate() {
        return date;
    }

    public boolean isPublication() {
        return publicationMed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_dmp(int id_dmp) {
        this.id_dmp = id_dmp;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPublication(boolean publication) {
        this.publicationMed = publication;
    }

    public int getType_examen() {
        return type_examen;
    }

    public boolean isPublicationMed() {
        return publicationMed;
    }

    public boolean isPublicationLab() {
        return publicationLab;
    }

    public void setType_examen(int type_examen) {
        this.type_examen = type_examen;
    }

    public void setPublicationMed(boolean publicationMed) {
        this.publicationMed = publicationMed;
    }

    public void setPublicationLab(boolean publicationLab) {
        this.publicationLab = publicationLab;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("eling.Demande.examen");
        sb.append("{id=").append(id);
        sb.append("{DMP=").append(id_dmp);
        sb.append(",type_examen='").append(type_examen);
        sb.append(", date='").append(date);
        sb.append(", publicationMed='").append(publicationMed);
        sb.append(", publicationLab='").append(publicationLab);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.id_dmp);
        hash = 53 * hash + Objects.hashCode(this.type_examen);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + (this.publicationMed ? 1 : 0);
        hash = 53 * hash + (this.publicationLab ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DemandeExamen other = (DemandeExamen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_dmp, other.id_dmp)) {
            return false;
        }
        if (!Objects.equals(this.type_examen, other.type_examen)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.publicationMed != other.publicationMed) {
            return false;
        }
        if (this.publicationLab != other.publicationLab) {
            return false;
        }
        return true;
    }







}