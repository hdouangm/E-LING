/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import application.domain.DonneesSociales;
/**
 *
 * @author asus
 */
@Stateless
public class DonneesSocialesRepository {
    @PersistenceContext(unitName="JPAPU")
    private EntityManager em;
    
    public List<DonneesSociales> list() {
        return em.createNamedQuery(DonneesSociales.FIND_ALL, DonneesSociales.class).getResultList();
    }
    
  /*  public DonneesSociales findByUsername(String login) {
        String query = "SELECT d FROM DonneesSociale d, Employe e , compteAphp"
                + "where d.id = e.donneessociale";
        return em.createQuery(query, DonneesSociales.class).getSingleResult();
    }*/

    public DonneesSociales find(Long id) {
        return em.find(DonneesSociales.class, id);
    }

    public Long save(DonneesSociales donnees) {
        em.persist(donnees);
        return donnees.getId();
    }

    public void update(DonneesSociales donnees) {
        em.merge(donnees);
    }

    public void delete(Long id) {
        DonneesSociales donnees = find(id);
        if (donnees == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(donnees);
    }
}
