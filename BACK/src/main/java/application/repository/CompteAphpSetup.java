package application.repository;


import application.eling.domain.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashSet;
import java.util.Set;

@Startup
@Singleton
public class CompteAphpSetup {

    @EJB
    private application.repository.PatientRepository patientRepository;
    @EJB
    private application.repository.EmployeRepository employeRepository;
    @EJB
    private application.repository.DMPRepository dmpRepository;
    @EJB
    private application.repository.ExamenRepository examenRepository;
    @EJB
    private application.repository.CompteAphpRepository compteAphpRepository;

    @PostConstruct
    private void createData() {

        Employe medecin = new Employe(null, null, new DonneesSociales("Piatek","Raphael",null,null,null,null,null,null), 0,null, null);
        Employe medecin2 = new Employe(null, null, new DonneesSociales("Cherifi","Rayane",null,null,null,null,null,null), 0,null, null);
        employeRepository.save(medecin);
        employeRepository.save(medecin2);

        DMP dmp = new DMP("196127748267245");

        Examen examen = new Examen(dmp, "10-10-2019", "url_image.png", medecin, null, null, null);
        examenRepository.save(examen);


        CompteAphp aphp = new CompteAphp("Raphael.Piatek@gmail.com", "azertyuiop", "FR", medecin, "8db2c76kfedke9rjlhgnuhftgo@group.calendar.google.com");
        CompteAphp aphp2 = new CompteAphp("Rayane.Cherifi@gmail.com", "azertyuiop","FR", medecin2,"nuv6q5n0djmrd650vv08u4b0vo@group.calendar.google.com");
        compteAphpRepository.save(aphp);
        compteAphpRepository.save(aphp2);




        Patient patient1 = new Patient(null, dmp,  new DonneesSociales("Lennon", "John", "2 Allée Iphigénie", "Lognes", "77185", "France", "12-10-1996", "M"), medecin2);
        Patient patient2 = new Patient(null, new DMP("190107745879212"), new DonneesSociales("Gourcuff", "Richard", "41 Rue du Landy", "Clichy", "92110", "France", "10-15-1990", "M"), medecin);
        Patient patient3 = new Patient(null, new DMP("193051341236704"), new DonneesSociales("Diaby", "Alexandre", "20 Rue Flegier", "Marseille", "13001", "France", "05-05-1993", "M"), medecin2);
        Patient patient4 = new Patient(null, new DMP(""), new DonneesSociales("Bale", "Nelson", "28 Bryantwood Rd", "Londres", "N7 7BE", "United Kingdom", "11-23-1985", "M"), medecin2);
        Patient patient5 = new Patient(null, new DMP("284069114678925"), new DonneesSociales("Leclerc", "Laure", "49 Rue d'Alsace", "Clichy", "92110", "France", "06-02-1984", "F"), medecin);
        Patient patient6 = new Patient(null, new DMP("272077755687165"), new DonneesSociales("Hamilton", "Susie", "12 Rue des Prés", "Meaux", "77100", "France", "07-12-1972", "F"), medecin);
        Patient patient7 = new Patient(null, new DMP(""), new DonneesSociales("Werner", "Thomas", "Hanauer Str. 46", "Munich", "80992", "Germany", "02-20-1965", "M"), medecin);
        Patient patient8 = new Patient(null, new DMP("160097501563480"), new DonneesSociales("Yang", "Jian", "11 Rue Rigault", "Nanterre", "92000", "France", "09-14-1960", "M"), medecin);
        Patient patient9 = new Patient(null, new DMP("291087713922670"), new DonneesSociales("Hernandez", "Marie", "31 Rue de Bellevue", "Torcy", "77200", "France", "08-10-1991", "F"), medecin2);
        Patient patient10 = new Patient(null, new DMP("289059155139780"), new DonneesSociales("Millet", "Julie", "23 Rue Mozart", "Nanterre", "92000", "France", "05-10-1989", "F"), medecin);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);
        patientRepository.save(patient6);
        patientRepository.save(patient7);
        patientRepository.save(patient8);
        patientRepository.save(patient9);
        patientRepository.save(patient10);



        compteAphpRepository.save(new CompteAphp("Robert.Petit@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Petit","Robert",null,null,null,null,null,null), 0,null,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

        compteAphpRepository.save(new CompteAphp("Hugo.Douangmala@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Douangmala","Hugo",null,null,null,null,null,null), 1,null,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
        compteAphpRepository.save(new CompteAphp("Serge.Durand@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Durand","Serge",null,null,null,null,null,null), 1,null,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

        compteAphpRepository.save(new CompteAphp("Cristiano.Santos@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Santos","Cristiano",null,null,null,null,null,null), 2,null,null),"77fp461o88d3u38iulb3s4oq90@group.calendar.google.com"));
        compteAphpRepository.save(new CompteAphp("Lionel.Rodriguez@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Rodriguez","Lionel",null,null,null,null,null,null), 2,null,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

        compteAphpRepository.save(new CompteAphp("Anne.Girard@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Girard","Anne",null,null,null,null,null,null), 3,null,null), "68hirq2m6le2adaq9tt3fpluo4@group.calendar.google.com"));
        compteAphpRepository.save(new CompteAphp("Nabil.Mahrez@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Mahrez","Nabil",null,null,null,null,null,null), 3,null,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

        compteAphpRepository.save(new CompteAphp("Stephanie.Dubois@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Dubois","Stephanie",null,null,null,null,null,null), 4,null,null),"2hvv87b8ts3cetsvuvc24f9qi4@group.calendar.google.com"));
        compteAphpRepository.save(new CompteAphp("Olivier.Glik@gmail.com", "azertyuiop","FR",new Employe(null, null, new DonneesSociales("Glik","Olivier",null,null,null,null,null,null), 4,null, null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));



    }
}
