package application.eling.repository;

import application.eling.domain.Diagnostique;
import application.eling.domain.Posologie;
import com.sun.tools.rngom.digested.DInterleavePattern;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DiagnostiqueRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Diagnostique> list() {
        return em.createNamedQuery(Diagnostique.FIND_ALL, Diagnostique.class).getResultList();
    }

    public Diagnostique find(Integer id) {
        return em.find(Diagnostique.class, id);
    }

    public Integer save(Diagnostique p) {
        em.persist(p);
        return p.getId();
    }

    public void update(Diagnostique p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        Diagnostique p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}