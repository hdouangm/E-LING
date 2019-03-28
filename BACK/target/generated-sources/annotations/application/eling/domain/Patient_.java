package application.eling.domain;

import application.eling.domain.DMP;
import application.eling.domain.DonneesSociales;
import application.eling.domain.Employe;
import application.eling.domain.NoeudHopital;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-28T16:36:08")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, Employe> employe;
    public static volatile SingularAttribute<Patient, NoeudHopital> noeudHopital;
    public static volatile SingularAttribute<Patient, DMP> dmp;
    public static volatile SingularAttribute<Patient, Integer> id;
    public static volatile SingularAttribute<Patient, DonneesSociales> donneesSociales;

}