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

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-20T12:51:34")
@StaticMetamodel(DMP.class)
public class DMP_ { 

    public static volatile SingularAttribute<DMP, String> ss;
    public static volatile SingularAttribute<DMP, String> InterventionsChir;
    public static volatile SingularAttribute<DMP, String> affectionCongenitales;
    public static volatile SingularAttribute<DMP, Examen> examen;
    public static volatile SingularAttribute<DMP, Posologie> posologie;
    public static volatile SingularAttribute<DMP, String> MaladieInfectieuse;
    public static volatile SingularAttribute<DMP, String> Allergies;
    public static volatile SingularAttribute<DMP, DemandeExamen> demandeExamen;
    public static volatile SingularAttribute<DMP, String> AutreAffections;
    public static volatile SingularAttribute<DMP, Diagnostique> diagnostique;
    public static volatile SingularAttribute<DMP, String> Profession;
    public static volatile SingularAttribute<DMP, String> Maladies;
    public static volatile SingularAttribute<DMP, Patient> patient;
    public static volatile SingularAttribute<DMP, DemandeIntervention> demandeIntervention;
    public static volatile SingularAttribute<DMP, Integer> id;
    public static volatile SingularAttribute<DMP, Intervention> intervention;
    public static volatile SingularAttribute<DMP, String> Motif;
    public static volatile SingularAttribute<DMP, String> Accidents;

}