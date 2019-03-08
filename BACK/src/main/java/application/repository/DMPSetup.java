package application.repository;

import application.eling.domain.DMP;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class DMPSetup {

  @EJB
  private DMPRepository repository;

  @PostConstruct
  private void createData() {
    repository.save(new DMP("2222"));
    repository.save(new DMP("Harry Potter and the Goblet of Fire"));
    repository.save(new DMP("La Carte et le Territoire"));
    repository.save(new DMP("Il Nome della Rosa"));
  }
}
