package application.eling.repository;

import application.eling.domain.Posologie;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Manages interactions with the database.
 * Created by jefferson on 11/11/2017.
 */
@Stateless
public class PosologieRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Posologie> list() {
        return em.createNamedQuery(Posologie.FIND_ALL, Posologie.class).getResultList();
    }

    public Posologie find(Integer id) {
        return em.find(Posologie.class, id);
    }

    public Integer save(Posologie p) {
        em.persist(p);
        return p.getId();
    }

    public void update(Posologie p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        Posologie p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}