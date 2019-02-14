package application.eling.repository;

import application.eling.domain.Patient;

import javax.ejb.NoSuchEntityException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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