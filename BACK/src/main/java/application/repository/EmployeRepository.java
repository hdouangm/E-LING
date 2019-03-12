/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.eling.domain.CompteAphp;
import application.eling.domain.Employe;
import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author asus
 */
@Stateless
public class EmployeRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;
    
     public List<Employe> list() {
        return em.createNamedQuery(Employe.FIND_ALL, Employe.class).getResultList();
    }
    
     public Employe findByLogin(String login) {
        
       Query query = em.createQuery("SELECT e FROM CompteAphp c ,Employe e WHERE c.username = :login"
               + " and e.compteAphp.id = c.id ");
       query.setParameter("login",login);
        //Query query = em.createQuery("select e from Employe e");
      
        return (Employe)query.getResultList().get(0);
    }
     
     
     
     public Employe find(int id) {
        return em.find(Employe.class, id);
    }
    
    public Integer save(Employe employe) {
        em.persist(employe);
        return employe.getId();
    }
    
      public void update(Employe employe) {
        em.merge(employe);
    }

    public void delete(Integer id) {
        Employe donnees = find(id);
        if (donnees == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(donnees);
    }
}
