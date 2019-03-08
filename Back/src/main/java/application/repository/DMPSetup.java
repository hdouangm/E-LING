/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repository;


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
public class DMPSetup {
  @EJB
  private DMPRepository repository;

  @PostConstruct
  private void createData() {
    }
}
