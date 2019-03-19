package application.repository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class PatientSetup {

  @EJB
  private application.repository.PatientRepository repository;

  /*
    @PostConstruct

  private void createData() {
    repository.save(new Book("2222", 23.99f, "Science fiction comedy book2", 354, Boolean.TRUE));
    repository.save(new Book("Harry Potter and the Goblet of Fire", 19.79f, "Science fiction (application.book.Book 4)", 734, Boolean.TRUE));
    repository.save(new Book("La Carte et le Territoire", 24.99f, "Prix Goncourt 2010", 428, Boolean.FALSE));
    repository.save(new Book("Il Nome della Rosa", 34.99f, "Science fiction comedy application.book", 354, Boolean.FALSE));
  */
}
