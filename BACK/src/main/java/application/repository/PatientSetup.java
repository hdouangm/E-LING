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
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Lennon", "John", "77200", "lognes", "77200", "FR", "10-12-1996", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Gourcuff", "Richard", "91200", "clichy", "91200", "FR", "15-10-1990", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Diaby", "Alexandre", "13000", "marseille", "13000", "FR", "05-05-1993", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Bale", "Nelson", null, null, null, "EN", "23-11-1985", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Leclerc", "Laure", "91200", "clichy", "91200", "FR", "02-06-1984", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Hamilton", "Susie", "77300", "meaux", "77300", "FR", "12-07-1972", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Werner", "Thomas", null, null, null, "DE", "20-02-1965", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Piatek", "Laurent", "92200", "nanterre", "92200", "FR", "14-09-1960", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Hernandez", "Marie", "77400", "torcy", "77400", "FR", "10-08-1991", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Millet", "Julie", "92200", "nanterre", "92200", "FR", "10-05-1989", "F")));

    }
}
