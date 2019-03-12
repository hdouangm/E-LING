package application.repository;


import application.eling.domain.DonneesSociales;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DonneeSocialeRepository {
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DonneesSociales> list() {
        return em.createNamedQuery(DonneesSociales.FIND_ALL, DonneesSociales.class).getResultList();
    }

    public DonneesSociales find(int id) {
        return em.find(DonneesSociales.class, id);
    }

    public List<DonneesSociales> findByCriteria(String nom){

        return em.createQuery("SELECT * from DonneesSociales d WHERE d.nom = :nom").getResultList();

    }

    public List<DonneesSociales> findByCriteria(String nom, String prenom){

        return em.createQuery("SELECT * from DonneesSociales d WHERE d.nom = :nom and d.prenom = :prenom").getResultList();

    }

    public Integer save(DonneesSociales donneeSociale) {
        em.persist(donneeSociale);
        return donneeSociale.getId();
    }

    public void update(DonneesSociales donneeSociale) {
        em.merge(donneeSociale);
    }

    public void delete(Integer id) {
        DonneesSociales donneeSociale = find(id);
        if (donneeSociale == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(donneeSociale);
    }




}
