package application.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import application.eling.domain.CompteAphp;
import application.eling.domain.DonneesSociales;
import application.eling.domain.Employe;

/**
 *
 * @author ophedinho
 */


@Stateless
public class CompteAphpRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<CompteAphp> list() {
        return em.createNamedQuery(CompteAphp.FIND_ALL, CompteAphp.class).getResultList();
    }

    /*public List<CompteAphp> find(CompteAphp cp) {
        String qr = "SELECT c FROM CompteAphp c WHERE c.username = '"+ cp.getUsername() 
                +"' AND c.password = '"+ cp.getPassword()+"'";
        Query query = em.createQuery(qr);
        return query.getResultList();
    }*/
    
    public List<CompteAphp> find(String usr, String pwd) {
        String qr = "SELECT c FROM CompteAphp c WHERE c.login = '"+ usr
                +"' AND c.motDePasse = '"+ pwd +"'";
        Query query = em.createQuery(qr);
        return query.getResultList();
    }
    public CompteAphp find(String usr) {
        return em.find(CompteAphp.class,usr);
    }

    public DonneesSociales findByLogin(String login){
        return em.find(CompteAphp.class,login).getEmploye().getDonneesSociales();

    }
    public Employe getEmploye(String login){
        return em.find(CompteAphp.class,login).getEmploye();

    }
    
    public String save(CompteAphp cp) {
        em.persist(cp);
        return cp.getLogin();
    }
    
}
