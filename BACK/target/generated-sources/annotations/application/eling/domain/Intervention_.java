package application.eling.domain;

import application.eling.domain.Acte;
import application.eling.domain.DMP;
import application.eling.domain.DemandeIntervention;
import application.eling.domain.Employe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-26T18:15:53")
@StaticMetamodel(Intervention.class)
public class Intervention_ { 

    public static volatile SingularAttribute<Intervention, String> date;
    public static volatile SingularAttribute<Intervention, Employe> responsable;
    public static volatile SingularAttribute<Intervention, Integer> prix;
    public static volatile SingularAttribute<Intervention, String> urlResultats;
    public static volatile SingularAttribute<Intervention, DMP> dmp;
    public static volatile SetAttribute<Intervention, Acte> codesActes;
    public static volatile SingularAttribute<Intervention, Boolean> publication;
    public static volatile SingularAttribute<Intervention, DemandeIntervention> demandeIntervention;
    public static volatile SingularAttribute<Intervention, Integer> id;
    public static volatile SingularAttribute<Intervention, String> type;
    public static volatile SingularAttribute<Intervention, Boolean> payer;
    public static volatile SingularAttribute<Intervention, String> lieu;

}