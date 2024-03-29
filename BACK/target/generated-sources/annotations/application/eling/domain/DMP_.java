package application.eling.domain;

import application.eling.domain.DemandeExamen;
import application.eling.domain.DemandeIntervention;
import application.eling.domain.Diagnostique;
import application.eling.domain.Examen;
import application.eling.domain.Intervention;
import application.eling.domain.Patient;
import application.eling.domain.Posologie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-28T16:36:08")
@StaticMetamodel(DMP.class)
public class DMP_ { 

    public static volatile SingularAttribute<DMP, String> ss;
    public static volatile SingularAttribute<DMP, String> profession;
    public static volatile SingularAttribute<DMP, String> allergies;
    public static volatile SingularAttribute<DMP, String> autreAffections;
    public static volatile SingularAttribute<DMP, String> affectionCongenitales;
    public static volatile SingularAttribute<DMP, String> waiting;
    public static volatile SingularAttribute<DMP, Examen> examen;
    public static volatile SingularAttribute<DMP, Posologie> posologie;
    public static volatile SingularAttribute<DMP, String> accidents;
    public static volatile SingularAttribute<DMP, String> waitingPos;
    public static volatile SingularAttribute<DMP, String> maladieInfectieuse;
    public static volatile SingularAttribute<DMP, String> interventionsChir;
    public static volatile SingularAttribute<DMP, DemandeExamen> demandeExamen;
    public static volatile SingularAttribute<DMP, Diagnostique> diagnostique;
    public static volatile SingularAttribute<DMP, String> maladies;
    public static volatile SingularAttribute<DMP, String> groupeSanguin;
    public static volatile SingularAttribute<DMP, String> waitingDiag;
    public static volatile SingularAttribute<DMP, Patient> patient;
    public static volatile SingularAttribute<DMP, String> groupeRhesus;
    public static volatile SingularAttribute<DMP, DemandeIntervention> demandeIntervention;
    public static volatile SingularAttribute<DMP, Integer> id;
    public static volatile SingularAttribute<DMP, String> motif;
    public static volatile SingularAttribute<DMP, Intervention> intervention;

}