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
       repository.save(new CompteAphp("Rayane", "la","FR",new Employe(null, null, new DonneesSociales("Rayane","Cherifi",null,null,null,null,null,null), 0,null),"nuv6q5n0djmrd650vv08u4b0vo@group.calendar.google.com"));
       repository.save(new CompteAphp("Hugo", "la","FR",new Employe(null, null, new DonneesSociales("Hugo","DOUANGMALA",null,null,null,null,null,null), 1,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));
       repository.save(new CompteAphp("Cristiano", "la","FR",new Employe(null, null, new DonneesSociales("Hugo","DOUANGMALA",null,null,null,null,null,null), 2,null),"qopic6kffqk2lgnjtti78ud1go@group.calendar.google.com"));

    }
}
