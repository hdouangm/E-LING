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
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile SingularAttribute<Examen, String> date;
    public static volatile SingularAttribute<Examen, Employe> responsable;
    public static volatile SingularAttribute<Examen, Integer> prix;
    public static volatile SingularAttribute<Examen, DMP> dmp;
    public static volatile SingularAttribute<Examen, Boolean> publication;
    public static volatile SetAttribute<Examen, Acte> codesActes;
    public static volatile SingularAttribute<Examen, List> resultats;
    public static volatile SingularAttribute<Examen, Integer> id;
    public static volatile SingularAttribute<Examen, Boolean> payer;

}