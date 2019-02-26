/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention;
import static com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention.FIND_ALL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ophedinho
 */

@Stateless
public class DemandeInterventionRepository {
    
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<DemandeIntervention> list() {
        return em.createNamedQuery(FIND_ALL, DemandeIntervention.class).getResultList();
    }
    
    public List<DemandeIntervention> listMed() {
        return em.createNamedQuery(DemandeIntervention.FIND_ALL_MED, DemandeIntervention.class).getResultList();
    }
    
    public List<DemandeIntervention> listLab() {
        return em.createNamedQuery(DemandeIntervention.FIND_ALL_LAB, DemandeIntervention.class).getResultList();
    }

    public DemandeIntervention find(Long id) {
        return em.find(DemandeIntervention.class, id);
    }
    
    public Long save(DemandeIntervention d_intervention) {
        em.persist(d_intervention);
        return d_intervention.getId();
    }
    
    public Long update(DemandeIntervention d_intervention){
        em.merge(d_intervention);
        return d_intervention.getId();
    }
    
    public void delete(Long d_examen){
        em.remove(d_examen);
    }
}
