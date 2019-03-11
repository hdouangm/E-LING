package application.repository;

import application.eling.domain.Patient;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Manages interactions with the database.
 * Created by jefferson on 11/11/2017.
 */
@Stateless
public class PatientRepository {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public List<Patient> list() {
        return em.createNamedQuery(Patient.FIND_ALL, Patient.class).getResultList();
    }

    public Patient find(int id) {
        return em.find(Patient.class, id);
    }

    public Integer save(Patient patient) {
        em.persist(patient);
        return patient.getId();
    }

    public List<Patient> findByDsNom(String dsNom){

        return em.createQuery("SELECT d from Patient d JOIN DonneesSociales ds WHERE ds.nom = '" + dsNom + "'").getResultList();

    }
    public List<Patient> findByDsNomPrenom(String dsNom,String dsPrenom){

        return em.createQuery("SELECT d from Patient d JOIN DonneesSociales ds WHERE ds.nom = '" + dsNom + "' and ds.prenom = '" + dsPrenom + '"').getResultList();

    }

    public void update(Patient patient) {
        em.merge(patient);
    }

    public void delete(Integer id) {
        Patient patient = find(id);
        if (patient == null) {
            throw new NoSuchEntityException("No entity with the id: " + id);
        }
        em.remove(patient);
    }
}