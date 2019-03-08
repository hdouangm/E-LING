/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;

import application.domain.DonneesSociales;
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
public class DonneesSocialesSetup {
  
  @EJB
  private DonneesSocialesRepository repository;

  @PostConstruct
  private void createData() {
    //repository.save(new DonneesSociales("nom1","prenom1","adresse1"));
   // repository.save(new DonneesSociales("nom2","prenom2","adresse2"));
   }
}
