package eling.upem.fr.e_lingandroid.model;

import java.io.Serializable;

public class DMP implements Serializable {
    public static final String FIND_ALL = "DMP.findAllDMPs";

    private Integer id;
    private String ss;
   // private Patient patient;

    public DMP(){

    }

    public DMP(String ss){
        this.ss = ss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", ss='" + ss + '\'' +
                '}';
    }
}
