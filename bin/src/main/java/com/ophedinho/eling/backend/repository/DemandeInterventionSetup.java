/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.demandeIntervention.domain.DemandeIntervention;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author ophedinho
 */

@Startup
@Singleton
public class DemandeInterventionSetup {
    @EJB
    private DemandeInterventionRepository repository;

    @PostConstruct
    private void createData() {
        repository.save(new DemandeIntervention());
        repository.save(new DemandeIntervention());
        repository.save(new DemandeIntervention());
    }
}
