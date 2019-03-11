package application.repository;
import application.eling.domain.DemandeExamen;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DemandeExamenRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DemandeExamen> list() {
        return em.createNamedQuery(DemandeExamen.FIND_ALL, DemandeExamen.class).getResultList();
    }

    public DemandeExamen find(Integer id) {
        return em.find(DemandeExamen.class, id);
    }

    public Integer save(DemandeExamen p) {
        em.persist(p);
        return p.getId();
    }

    public void update(DemandeExamen p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        DemandeExamen p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}