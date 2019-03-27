package application.eling.domain;

import application.eling.domain.DMP;
import application.eling.domain.DonneesSociales;
import application.eling.domain.NoeudHopital;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-26T17:20:32")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, NoeudHopital> noeudHopital;
    public static volatile SingularAttribute<Patient, DMP> dmp;
    public static volatile SingularAttribute<Patient, Integer> id;
    public static volatile SingularAttribute<Patient, DonneesSociales> donneesSociales;

}