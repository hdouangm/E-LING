package application.eling.domain;

import application.eling.domain.Employe;
import application.eling.domain.Posologie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T02:14:48")
@StaticMetamodel(SuiviTraitement.class)
public class SuiviTraitement_ { 

    public static volatile SingularAttribute<SuiviTraitement, String> date;
    public static volatile SingularAttribute<SuiviTraitement, Boolean> priseTraitement;
    public static volatile SingularAttribute<SuiviTraitement, Employe> infirmiere;
    public static volatile SingularAttribute<SuiviTraitement, Posologie> posologie;
    public static volatile SingularAttribute<SuiviTraitement, Integer> id;

}