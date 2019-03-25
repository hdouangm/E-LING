package application.eling.domain;

import application.eling.domain.Acte;
import application.eling.domain.DMP;
import application.eling.domain.Employe;
import application.eling.domain.SuiviTraitement;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T01:37:09")
=======
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T00:46:39")
>>>>>>> 1c1caa06de7d72513fab171e0d734f68be193887
@StaticMetamodel(Posologie.class)
public class Posologie_ { 

    public static volatile SingularAttribute<Posologie, Employe> responsable;
    public static volatile SingularAttribute<Posologie, String> dateDebut;
    public static volatile SingularAttribute<Posologie, Integer> prix;
    public static volatile SingularAttribute<Posologie, DMP> dmp;
    public static volatile SingularAttribute<Posologie, Boolean> publication;
    public static volatile SetAttribute<Posologie, Acte> codesActes;
    public static volatile SingularAttribute<Posologie, String> posologie;
    public static volatile SingularAttribute<Posologie, Integer> id;
    public static volatile SingularAttribute<Posologie, String> dateFin;
    public static volatile SetAttribute<Posologie, SuiviTraitement> suiviTraitement;
    public static volatile SingularAttribute<Posologie, Boolean> payer;

}