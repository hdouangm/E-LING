package application.eling.domain;

import application.eling.domain.Acte;
import application.eling.domain.DMP;
import application.eling.domain.Employe;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-08T17:29:52")
@StaticMetamodel(Posologie.class)
public class Posologie_ { 

    public static volatile SingularAttribute<Posologie, Employe> responsable;
    public static volatile SingularAttribute<Posologie, Integer> prix;
    public static volatile SingularAttribute<Posologie, DMP> dmp;
    public static volatile SingularAttribute<Posologie, Boolean> publication;
    public static volatile SetAttribute<Posologie, Acte> codesActes;
    public static volatile SingularAttribute<Posologie, String> posologie;
    public static volatile SingularAttribute<Posologie, Integer> id;
    public static volatile SingularAttribute<Posologie, List> suiviTraitement;
    public static volatile SingularAttribute<Posologie, Boolean> payer;

}