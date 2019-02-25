package main.java.core;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import java.sql.Date;
import java.util.List;

public class ConstanteVitale {
    public static final String FIND_ALL = "ConstanteVitale.findAllConstanteVitales";

    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private DMP dmp;
    private Date date;
    private String constante;

    public ConstanteVitale(){

    }

    public ConstanteVitale(DMP dmp, Date date, String constante) {
        this.dmp = dmp;
        this.date = date;
        this.constante = constante;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConstante() {
        return constante;
    }

    public void setConstante(String constante) {
        this.constante = constante;
    }


    
    

    @Override
    public String toString() {
        return "ConstantesVitales{" +
                "id=" + id +
                ", dmp=" + dmp +
                ", date=" + date +
                ", constante=" + constante;
    }
}
