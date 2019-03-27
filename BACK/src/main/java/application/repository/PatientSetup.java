package application.repository;

import application.eling.domain.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class PatientSetup {


    @PostConstruct

  private void createData() {



    }
}
