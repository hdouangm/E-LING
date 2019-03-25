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
       repository.save(new CompteAphp("Rayane@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Cherifi","Rayane",null,null,null,null,null,null), 0,null),"nuv6q5n0djmrd650vv08u4b0vo@group.calendar.google.com"));
       repository.save(new CompteAphp("Hugo@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Douangmala","Hugo",null,null,null,null,null,null), 0,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

       repository.save(new CompteAphp("Cristiano@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Dos Santos","Cristiano",null,null,null,null,null,null), 1,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
       repository.save(new CompteAphp("Lionel@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Rodriguez","Lionel",null,null,null,null,null,null), 1,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

       repository.save(new CompteAphp("Serge@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Durand","Serge",null,null,null,null,null,null), 2,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
       repository.save(new CompteAphp("Robert@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Petit","Robert",null,null,null,null,null,null), 2,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

       repository.save(new CompteAphp("Anne@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Girard","Anne",null,null,null,null,null,null), 3,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
       repository.save(new CompteAphp("Roger@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Leroy","Roger",null,null,null,null,null,null), 3,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

       repository.save(new CompteAphp("Stephanie@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Dubois","Stephanie",null,null,null,null,null,null), 4,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
       repository.save(new CompteAphp("Olivier@gmail.com", "la","FR",new Employe(null, null, new DonneesSociales("Glik","Olivier",null,null,null,null,null,null), 4,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));


    }
}
