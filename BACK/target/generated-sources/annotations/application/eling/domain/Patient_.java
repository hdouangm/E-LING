package application.eling.domain;

import application.eling.domain.DMP;
import application.eling.domain.DonneesSociales;
import application.eling.domain.NoeudHopital;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T23:46:31")
=======
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T18:29:26")
>>>>>>> e194f349acb9645c1ca154e8c9a9953aeea7c257
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, NoeudHopital> noeudHopital;
    public static volatile SingularAttribute<Patient, DMP> dmp;
    public static volatile SingularAttribute<Patient, Integer> id;
    public static volatile SingularAttribute<Patient, DonneesSociales> donneesSociales;

}