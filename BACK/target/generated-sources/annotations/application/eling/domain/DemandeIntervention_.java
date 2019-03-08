package application.eling.domain;

import application.eling.domain.DMP;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-08T17:29:52")
@StaticMetamodel(DemandeIntervention.class)
public class DemandeIntervention_ { 

    public static volatile SingularAttribute<DemandeIntervention, String> date;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> demandeRemplie;
    public static volatile SingularAttribute<DemandeIntervention, DMP> dmp;
    public static volatile SingularAttribute<DemandeIntervention, Boolean> publierDemande;
    public static volatile SingularAttribute<DemandeIntervention, Integer> id;
    public static volatile SingularAttribute<DemandeIntervention, String> type;

}