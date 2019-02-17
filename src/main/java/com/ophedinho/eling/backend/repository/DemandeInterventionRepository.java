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

    public DemandeIntervention find(Long id) {
        return em.find(DemandeIntervention.class, id);
    }
    
    public Long save(DemandeIntervention d_intervention) {
        em.persist(d_intervention);
        return d_intervention.getId();
    }
    
    public Long update(Long id, DemandeIntervention d_intervention){
        DemandeIntervention d_intervention_new = new DemandeIntervention(id, d_intervention.getId_dmp(), 
                d_intervention.getType(), d_intervention.isPublication());
        this.delete(id);
        return this.save(d_intervention_new);
    }
    
    public void delete(Long d_examen){
        em.remove(d_examen);
    }
}
