/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.eling.domain.TypeIntervention;
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
public class TypeInterventionSetup {
    
    @EJB
    private TypeInterventionRepository repository;

    @PostConstruct
    private void createData() {
        repository.save(new TypeIntervention("Chirurgie cardiaque"));
        repository.save(new TypeIntervention("Chirurgie dentaire"));
        repository.save(new TypeIntervention());
    }
    
}
