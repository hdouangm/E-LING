package application.repository;


import application.domain.CompteAphp;
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
      /*  repository.save(new CompteAphp("ophelie", "amolo"));
        repository.save(new CompteAphp("rokia", "diallo", 2L));
        repository.save(new CompteAphp("jihanne", "ikmel"));*/
    }
}
