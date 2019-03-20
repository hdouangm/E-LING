package application.repository;
import application.eling.domain.DMP;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DMPRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DMP> list() {
        return em.createNamedQuery(DMP.FIND_ALL, DMP.class).getResultList();
    }

    public List<DMP> find(int id) {
        return em.createQuery("SELECT d from DMP d JOIN Patient p WHERE  p.id = :id ").getResultList();
    }

    public Integer save(DMP p) {
        em.persist(p);
        return p.getId();
    }

    public void update(DMP p) {
        em.merge(p);
    }



    public List<DMP> findByParam(String ss) {
        TypedQuery<DMP> query = em.createQuery(
                "SELECT d FROM DMP d WHERE d.ss LIKE :ss", DMP.class);
        return query.setParameter("ss", ss).getResultList();
    }

    public void setProfession(String ss,String prof){

        em.createQuery("UPDATE DMP d SET Profession = :prof WHERE d.ss = :ss",DMP.class);

    }
}