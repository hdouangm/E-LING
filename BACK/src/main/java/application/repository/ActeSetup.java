package application.repository;

import application.eling.domain.Acte;
import application.eling.domain.Examen;
import application.eling.domain.Intervention;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Startup
@Singleton
public class ActeSetup {

  @EJB
  private ActeRepository acterepository;

  @EJB
  private InterventionRepository interventionrepository;

  @PostConstruct
  private void createData() {
    Acte a = new Acte("lol",10);
    Acte b = new Acte("lol",15);
    Set<Acte> l = new HashSet<Acte>(0);
    acterepository.save(a);
    acterepository.save(b);
    acterepository.update(a);

    interventionrepository.save(new Intervention(null, null,"lol",null,null,false,l,true, null));
  }
}
