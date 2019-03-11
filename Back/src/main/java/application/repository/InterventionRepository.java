package application.repository;

import application.eling.domain.Intervention;
import application.eling.domain.Posologie;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InterventionRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Intervention> list() {
        return em.createNamedQuery(Intervention.FIND_ALL, Intervention.class).getResultList();
    }

    public Intervention find(Integer id) {
        return em.find(Intervention.class, id);
    }

    public Integer save(Intervention p) {
        em.persist(p);
        return p.getId();
    }

    public void update(Intervention p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        Intervention p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}