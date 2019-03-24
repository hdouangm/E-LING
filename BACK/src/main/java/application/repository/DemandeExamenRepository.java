/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.eling.domain.DemandeExamen;
import static application.eling.domain.DemandeExamen.FIND_ALL;
import static application.eling.domain.DemandeExamen.FIND_ALL_LAB;
import static application.eling.domain.DemandeExamen.FIND_ALL_MED;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ophedinho
 */

@Stateless
public class DemandeExamenRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DemandeExamen> list() {
        return em.createNamedQuery(FIND_ALL, DemandeExamen.class).getResultList();
    }

    public List<DemandeExamen> listMed() {
        return em.createNamedQuery(DemandeExamen.FIND_ALL_MED, DemandeExamen.class).getResultList();
    }

    public List<DemandeExamen> listLab() {
        return em.createNamedQuery(DemandeExamen.FIND_ALL_LAB, DemandeExamen.class).getResultList();
    }

    public DemandeExamen find(int id) {
        return em.find(DemandeExamen.class, id);
    }

    public int save(DemandeExamen d_examen) {
        em.persist(d_examen);
        return d_examen.getId();
    }

    public int update(DemandeExamen dExamen){
        em.merge(dExamen);
        return dExamen.getId();
    }

    public void delete(int d_examen){
        em.remove(d_examen);
    }
}