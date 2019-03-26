package application.eling.domain;

import application.eling.domain.Acte;
import application.eling.domain.DMP;
import application.eling.domain.Employe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T23:46:31")
=======
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T18:29:26")
>>>>>>> e194f349acb9645c1ca154e8c9a9953aeea7c257
@StaticMetamodel(Diagnostique.class)
public class Diagnostique_ { 

    public static volatile SingularAttribute<Diagnostique, String> date;
    public static volatile SingularAttribute<Diagnostique, Employe> responsable;
    public static volatile SingularAttribute<Diagnostique, Integer> prix;
    public static volatile SingularAttribute<Diagnostique, DMP> dmp;
    public static volatile SingularAttribute<Diagnostique, Boolean> publication;
    public static volatile SetAttribute<Diagnostique, Acte> codesActes;
    public static volatile SingularAttribute<Diagnostique, Integer> id;
    public static volatile SingularAttribute<Diagnostique, String> diagnostic;
    public static volatile SingularAttribute<Diagnostique, Boolean> payer;

}