package application.eling.domain;

import application.eling.domain.DMP;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-08T17:29:52")
@StaticMetamodel(DemandeExamen.class)
public class DemandeExamen_ { 

    public static volatile SingularAttribute<DemandeExamen, String> date;
    public static volatile SingularAttribute<DemandeExamen, Boolean> demandeRemplie;
    public static volatile SingularAttribute<DemandeExamen, DMP> dmp;
    public static volatile SingularAttribute<DemandeExamen, Boolean> publierDemande;
    public static volatile SingularAttribute<DemandeExamen, Integer> id;
    public static volatile SingularAttribute<DemandeExamen, String> type;

}