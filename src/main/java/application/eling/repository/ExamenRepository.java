package application.eling.repository;

import application.eling.domain.Examen;

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
public class ExamenRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Examen> list() {
        return em.createNamedQuery(Examen.FIND_ALL, Examen.class).getResultList();
    }

    public Examen find(Integer id) {
        return em.find(Examen.class, id);
    }

    public Integer save(Examen p) {
        em.persist(p);
        return p.getId();
    }

    public void update(Examen p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        Examen p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}