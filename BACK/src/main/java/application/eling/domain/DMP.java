package application.eling.domain;

import javax.persistence.*;

import java.io.Serializable;

import static application.eling.domain.DMP.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM DMP b ORDER BY b.id DESC")
public class DMP implements Serializable {
    public static final String FIND_ALL = "DMP.findAllDMPs";

    @Id
    @GeneratedValue
    private Integer id;
    private String ss;
    @OneToOne(cascade=CascadeType.ALL)
    private Patient patient;
    @OneToOne(cascade=CascadeType.ALL)
    private Posologie posologie;
    @OneToOne(cascade=CascadeType.ALL)
    private Diagnostique diagnostique;
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
