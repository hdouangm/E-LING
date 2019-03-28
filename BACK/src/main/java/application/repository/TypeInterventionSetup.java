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
//        repository.save(new TypeIntervention("Chirurgie vasculaire"));
//        repository.save(new TypeIntervention("Chirurgie dentaire"));
        repository.save(new TypeIntervention("Chirurgie thoracique"));
        repository.save(new TypeIntervention("Neurochirurgie"));
//        repository.save(new TypeIntervention("Chirurgie plastique"));
//        repository.save(new TypeIntervention("Chirurgie orthopédique"));
//        repository.save(new TypeIntervention("Chirurgie gynécologique"));
        repository.save(new TypeIntervention("Chirurgie cardiovasculaire"));

        repository.save(new TypeIntervention());
    }
    
}
