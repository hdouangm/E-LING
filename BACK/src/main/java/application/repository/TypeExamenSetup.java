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
        repository.save(new TypeExamen("IRM cérébral"));
        repository.save(new TypeExamen("IRM Abdominal "));
        repository.save(new TypeExamen("IRM du genou"));
        repository.save(new TypeExamen("IRM des hanches"));
        repository.save(new TypeExamen("IRM thoracique"));
        repository.save(new TypeExamen("Echographie thyroïdienne"));
        repository.save(new TypeExamen("Echographie abdominale"));
        repository.save(new TypeExamen("Scanner encéphalique"));
        repository.save(new TypeExamen("Scanner thoracique"));
        repository.save(new TypeExamen("Scanner pelvien"));
        repository.save(new TypeExamen("Scanner rachidien"));
        repository.save(new TypeExamen("Scanner dentaire"));
        repository.save(new TypeExamen("Radiographie du thorax"));
        repository.save(new TypeExamen("Radiographie dentaire"));
        repository.save(new TypeExamen("Radiographie du bassin"));
        repository.save(new TypeExamen("Electrocardiographie"));
        repository.save(new TypeExamen("EMG"));
        repository.save(new TypeExamen());
    }
    
}
