package application.responsableLaboratoire.domain;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Examen {
        @Id
        private Integer id;
	private String name;
        private Date date;
        private Double price;
        private ArrayList<String> results;
        private Boolean paid;
        private ArrayList<String> acts;
        private Boolean published; 
        private Integer responsible;
        private Integer dmp;
       
        public Examen() {
            System.out.println("test...");
	}

    public Examen(String name, Date date, Double price, ArrayList<String> results, Boolean paid, ArrayList<String> acts, Boolean published, Integer responsible, Integer dmp) {
        this.id = 0; // for the test
        this.name = name;
        this.date = date;
        this.price = price;
        this.results = results;
        this.paid = paid;
        this.acts = acts;
        this.published = published;
        this.responsible = responsible;
        this.dmp = dmp;
    }
    
    public static ArrayList<Examen> getAll(){
        Examen e1 = new Examen("exam1", new Date(2019, 2, 3), 120.2, new ArrayList<String>(), true, new ArrayList<String>(), false, 1, 1);
        Examen e2 = new Examen("exam2", new Date(2019, 2, 3), 120.2, new ArrayList<String>(), true, new ArrayList<String>(), false, 1, 1);
        Examen e3 = new Examen("exam3", new Date(2019, 2, 3), 120.2, new ArrayList<String>(), true, new ArrayList<String>(), false, 1, 1);
        Examen e4 = new Examen("exam4", new Date(2019, 2, 3), 120.2, new ArrayList<String>(), true, new ArrayList<String>(), false, 1, 1);
        
        e1.setId(1);
        e2.setId(2);
        e3.setId(3);
        e4.setId(4);
        
        e1.getActs().add("act1");
        e1.getActs().add("act2");
        e1.getResults().add("result1");
        e1.getResults().add("result2");
        
        e2.getActs().add("act1");
        e2.getActs().add("act2");
        e2.getResults().add("result1");
        e2.getResults().add("result2");
        
        e3.getActs().add("act1");
        e3.getActs().add("act2");
        e3.getResults().add("result1");
        e3.getResults().add("result2");
        
        e4.getActs().add("act1");
        e4.getActs().add("act2");
        e4.getResults().add("result1");
        e4.getResults().add("result2");
        
        ArrayList<Examen> exams = new ArrayList<>();
        exams.add(e1);
        exams.add(e2);
        exams.add(e3);
        exams.add(e4);
        
        return exams;
    }
    
    public static void supprimerExamen(Long id){
        
    }
    
    public static void publierExamen(Long id){
        
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public ArrayList<String> getActs() {
        return acts;
    }

    public void setActs(ArrayList<String> acts) {
        this.acts = acts;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Integer getResponsible() {
        return responsible;
    }

    public void setResponsible(Integer responsible) {
        this.responsible = responsible;
    }

    public Integer getDmp() {
        return dmp;
    }

    public void setDmp(Integer dmp) {
        this.dmp = dmp;
    }
        
        public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
        
	public void creerExamen() {
		System.out.println("Examen créé...");
                System.out.println(this.toString());
	}
	public void modifierExamen() {
		System.out.println("Examen Modifié");
	}
	public void supprimerExamen() {
		System.out.println("Examen Supprimé");
	}
	public void setPublie(boolean value) {
		System.out.println("Examen publié");
	}

    @Override
    public String toString() {
        return "Examen{" + "id=" + id + ", name=" + name + ", date=" + date + ", price=" + price + ", results=" + results + ", paid=" + paid + ", acts=" + acts + ", published=" + published + ", responsible=" + responsible + ", dmp=" + dmp + '}';
    }

}
