package application.repository;


import application.eling.domain.CompteAphp;
import application.eling.domain.DonneesSociales;
import application.eling.domain.Employe;
import application.eling.domain.NoeudHopital;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class CompteAphpSetup {

    @EJB
    private CompteAphpRepository repository;

    @PostConstruct
    private void createData() {
       repository.save(new CompteAphp("fafa", "la","FR",new Employe(null, null, new DonneesSociales("lepatron","du77",null,null,null,null,null,null), 0,null)));
       repository.save(new CompteAphp("nana", "la","FR",new Employe(null, null, new DonneesSociales("lebooss","du77",null,null,null,null,null,null), 1,null)));

    }
}
