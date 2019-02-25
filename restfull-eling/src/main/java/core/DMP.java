package main.java.core;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



public class DMP {
    public static final String FIND_ALL = "DMP.findAllDMPs";

    private Integer id;
    private String ss;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ConstanteVitale> constantes;

    public DMP(){

    }

    public DMP(String ss){
        this.ss = ss;
    }

    @Id
    @GeneratedValue
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
    

    public Set<ConstanteVitale> getConstantes() {
		return constantes;
	}

	public void setConstantes(Set<ConstanteVitale> constantes) {
		this.constantes = constantes;
	}

	@Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", ss='" + ss + '\'' +
                '}';
    }
}
