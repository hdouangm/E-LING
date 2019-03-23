package application.repository;
import application.eling.domain.DMP;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.PathParam;
import java.util.List;

@Stateless
public class DMPRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DMP> list() {
        return em.createNamedQuery(DMP.FIND_ALL, DMP.class).getResultList();
    }

    public DMP find(Integer id) {
        return em.find(DMP.class, id);
    }

    public List<DMP> findByIDPatient(Integer id){
        return em.createQuery("SELECT d.dmp from Patient d WHERE  d.patient.id = " + id).getResultList();

    }
    public Integer save(DMP p) {
        em.persist(p);
        return p.getId();
    }

    public void update(DMP p) {
        em.merge(p);
    }

    public void delete(Integer id) {
        DMP p = find(id);
        if (p == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(p);
    }

    public List<DMP> findByParam(String ss) {
        TypedQuery<DMP> query = em.createQuery(
                "SELECT d FROM DMP d WHERE d.ss LIKE :ss", DMP.class);
        return query.setParameter("ss", ss).getResultList();
    }

    public void setProfession(DMP dmp ){

        em.merge(dmp);

    }
}