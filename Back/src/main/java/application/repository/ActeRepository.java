package application.repository;

import application.eling.domain.Acte;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ActeRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Acte> list() {
        return em.createNamedQuery(Acte.FIND_ALL, Acte.class).getResultList();
    }

    public Acte find(Integer id) {
        return em.find(Acte.class, id);
    }

    public Integer save(Acte p) {
        em.persist(p);
        return p.getId();
    }

    public void update(Acte p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        Acte p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}