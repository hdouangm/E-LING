/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.domain.DMP;
import application.domain.Patient;
import java.util.List;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asus
 */
@Stateless
public class DMPRepository {


    @PersistenceContext(unitName="JPAPU")
    private EntityManager em;
    
    public DMP find(Long id) {
        return em.find(DMP.class, id);
    }
    
    public DMP findByPatient(Patient patient) {
        return em.find(DMP.class, patient.getDmp().getId());
    }

}
