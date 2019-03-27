package application.repository;

import application.eling.domain.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class PatientSetup {

  @EJB
  private application.repository.PatientRepository repository;

  @EJB
  private application.repository.EmployeRepository employeRepository;

  @EJB
  private application.repository.DMPRepository dmpRepository;

  @EJB
  private application.repository.ExamenRepository examenRepository;


    @PostConstruct

  private void createData() {

      Employe medecin = new Employe(null, null, new DonneesSociales("Piatek","Raphael",null,null,null,null,null,null), 0,null, null);
      employeRepository.save(medecin);

      DMP dmp = new DMP("196127748267245");

      Examen examen = new Examen(dmp, "10-10-2019", "url_image.png", medecin, null, null, null);
      examenRepository.save(examen);

      dmp.setExamen(examen);
      dmpRepository.save(dmp);


      repository.save(new Patient(null, dmp,  new DonneesSociales("Lennon", "John", "2 Allée Iphigénie", "Lognes", "77185", "France", "12-10-1996", "M"), medecin));
      repository.save(new Patient(null, new DMP("190107745879212"), new DonneesSociales("Gourcuff", "Richard", "41 Rue du Landy", "Clichy", "92110", "France", "10-15-1990", "M"), medecin));
      repository.save(new Patient(null, new DMP("193051341236704"), new DonneesSociales("Diaby", "Alexandre", "20 Rue Flegier", "Marseille", "13001", "France", "05-05-1993", "M"), medecin));
      repository.save(new Patient(null, new DMP(""), new DonneesSociales("Bale", "Nelson", "28 Bryantwood Rd", "Londres", "N7 7BE", "United Kingdom", "11-23-1985", "M"), medecin));
      repository.save(new Patient(null, new DMP("284069114678925"), new DonneesSociales("Leclerc", "Laure", "49 Rue d'Alsace", "Clichy", "92110", "France", "06-02-1984", "F"), medecin));
      repository.save(new Patient(null, new DMP("272077755687165"), new DonneesSociales("Hamilton", "Susie", "12 Rue des Prés", "Meaux", "77100", "France", "07-12-1972", "F"), medecin));
      repository.save(new Patient(null, new DMP(""), new DonneesSociales("Werner", "Thomas", "Hanauer Str. 46", "Munich", "80992", "Germany", "02-20-1965", "M"), medecin));
      repository.save(new Patient(null, new DMP("160097501563480"), new DonneesSociales("Yang", "Jian", "11 Rue Rigault", "Nanterre", "92000", "France", "09-14-1960", "M"), medecin));
      repository.save(new Patient(null, new DMP("291087713922670"), new DonneesSociales("Hernandez", "Marie", "31 Rue de Bellevue", "Torcy", "77200", "France", "08-10-1991", "F"), medecin));
      repository.save(new Patient(null, new DMP("289059155139780"), new DonneesSociales("Millet", "Julie", "23 Rue Mozart", "Nanterre", "92000", "France", "05-10-1989", "F"), medecin));

    }
}
