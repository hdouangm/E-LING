package application.repository;

import application.eling.domain.DMP;
import application.eling.domain.DonneesSociales;
import application.eling.domain.Patient;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class PatientSetup {

  @EJB
  private application.repository.PatientRepository repository;


    @PostConstruct

  private void createData() {
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("John", "Lenon", "77200", "lognes", "88722", "FR", "10-10-1996", "M")));
    }
}
