package application.eling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.eling.domain.NoeudHopital.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM NoeudHopital b ORDER BY b.id DESC")
public class NoeudHopital {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopitals";
    @Id
    @GeneratedValue
    private Integer id;

    public NoeudHopital(){

    }

    public Integer getId(){
        return id;
    }

    @Override
    public String toString() {
        return "NoeudHopital{" +
                "id=" + id +
                '}';
    }
}
