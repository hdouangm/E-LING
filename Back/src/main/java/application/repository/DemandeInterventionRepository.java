package application.repository;
import application.eling.domain.DemandeIntervention;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DemandeInterventionRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DemandeIntervention> list() {
        return em.createNamedQuery(DemandeIntervention.FIND_ALL, DemandeIntervention.class).getResultList();
    }

    public DemandeIntervention find(Integer id) {
        return em.find(DemandeIntervention.class, id);
    }

    public Integer save(DemandeIntervention p) {
        em.persist(p);
        return p.getId();
    }

    public void update(DemandeIntervention p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        DemandeIntervention p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}