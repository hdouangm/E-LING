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
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Lennon", "John", "77200", "lognes", "77200", "FR", "12-10-1996", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Gourcuff", "Richard", "91200", "clichy", "91200", "FR", "10-15-1990", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Diaby", "Alexandre", "13000", "marseille", "13000", "FR", "05-05-1993", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Bale", "Nelson", null, null, null, "EN", "11-23-1985", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Leclerc", "Laure", "91200", "clichy", "91200", "FR", "06-02-1984", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Hamilton", "Susie", "77300", "meaux", "77300", "FR", "07-12-1972", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Werner", "Thomas", null, null, null, "DE", "02-20-1965", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Piatek", "Laurent", "92200", "nanterre", "92200", "FR", "09-14-1960", "M")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Hernandez", "Marie", "77400", "torcy", "77400", "FR", "08-10-1991", "F")));
      repository.save(new Patient(null, new DMP("19610"), new DonneesSociales("Millet", "Julie", "92200", "nanterre", "92200", "FR", "05-10-1989", "F")));

    }
}
