package application.repository;
import application.eling.domain.NoeudHopital;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NoeudHopitalRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<NoeudHopital> list() {
        return em.createNamedQuery(NoeudHopital.FIND_ALL, NoeudHopital.class).getResultList();
    }

    public NoeudHopital find(Integer id) {
        return em.find(NoeudHopital.class, id);
    }

    public Integer save(NoeudHopital p) {
        em.persist(p);
        return p.getId();
    }

    public void update(NoeudHopital p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        NoeudHopital p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}