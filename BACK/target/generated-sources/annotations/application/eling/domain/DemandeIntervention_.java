package application.eling.domain;

import application.eling.domain.DMP;
import application.eling.domain.Intervention;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-24T23:21:37")
@StaticMetamodel(DemandeIntervention.class)
public class DemandeIntervention_ { 

    public static volatile SingularAttribute<DemandeIntervention, String> date;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> demandeRemplie;
    public static volatile SingularAttribute<DemandeIntervention, DMP> dmp;
    public static volatile SingularAttribute<DemandeIntervention, Integer> type_intervention;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> publierDemande;
    public static volatile SingularAttribute<DemandeIntervention, Integer> id_dmp;
    public static volatile SingularAttribute<DemandeIntervention, Integer> id;
    public static volatile SingularAttribute<DemandeIntervention, String> type;
    public static volatile SingularAttribute<DemandeIntervention, Intervention> intervention;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> publicationMed;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> publicationLab;

}