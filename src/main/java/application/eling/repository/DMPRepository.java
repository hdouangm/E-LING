package application.eling.repository;
import application.eling.domain.DMP;
import application.eling.domain.Patient;

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
public class DMPRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DMP> list() {
        return em.createNamedQuery(DMP.FIND_ALL, DMP.class).getResultList();
    }

    public DMP find(Long id) {
        return em.find(DMP.class, id);
    }

    public Integer save(DMP p) {
        em.persist(p);
        return p.getId();
    }

    public void update(DMP p) {
        em.merge(p);
    }

    public void delete(Long id) {
        DMP p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}