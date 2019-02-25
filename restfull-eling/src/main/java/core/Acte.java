package main.java.core;

import javax.persistence.*;


import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;

@Entity
public class Acte implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private Integer prix;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="exmenActeID")
    private Examen examen;
    
    public Acte() {

    }

    public Acte(String description, Integer prix) {
        this.description = description;
        this.prix = prix;
    }

    
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

    public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	@Override
    public String toString() {
        return "Acte{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acte other = (Acte) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		return true;
	}
	
	
}

