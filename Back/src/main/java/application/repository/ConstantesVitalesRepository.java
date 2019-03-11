package application.repository;
import application.eling.domain.ConstantesVitales;
import application.eling.domain.DMP;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ConstantesVitalesRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<ConstantesVitales> list() {
        return em.createNamedQuery(ConstantesVitales.FIND_ALL, ConstantesVitales.class).getResultList();
    }

    public ConstantesVitales find(Integer id) {
        return em.find(ConstantesVitales.class, id);
    }

    public Integer save(ConstantesVitales p) {
        em.persist(p);
        return p.getId();
    }

    public void update(ConstantesVitales p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        ConstantesVitales p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }
}