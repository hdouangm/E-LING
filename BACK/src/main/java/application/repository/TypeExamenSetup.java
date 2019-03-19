/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.eling.domain.TypeExamen;
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
public class TypeExamenSetup {
    
    @EJB
    private TypeExamenRepository repository;

    @PostConstruct
    private void createData() {
        repository.save(new TypeExamen("IRM"));
        repository.save(new TypeExamen("EMG"));
        repository.save(new TypeExamen());
    }
    
}
