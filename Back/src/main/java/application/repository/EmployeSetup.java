/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.domain.CompteAphp;
import application.domain.DonneesSociales;
import application.domain.Employe;
import application.domain.NoeudHopital;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author asus
 */
@Startup
@Singleton
public class EmployeSetup {
    @EJB
    private EmployeRepository repository;

    @PostConstruct
    private void createData() {
      /*  repository.save(new Employe(new NoeudHopital(205),new CompteAphp("ophelie", "amolo"),
                new DonneesSociales("ophelie", "amolo", "adresse1"),
                1,
                null));  */
    }
}
