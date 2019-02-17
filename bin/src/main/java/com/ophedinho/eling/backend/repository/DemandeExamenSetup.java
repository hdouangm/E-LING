/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ophedinho.eling.backend.repository;

import com.ophedinho.eling.backend.demandeExamen.domain.DemandeExamen;
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
public class DemandeExamenSetup {
    @EJB
    private DemandeExamenRepository repository;

    @PostConstruct
    private void createData() {
        repository.save(new DemandeExamen());
        repository.save(new DemandeExamen());
        repository.save(new DemandeExamen());
    }
}
