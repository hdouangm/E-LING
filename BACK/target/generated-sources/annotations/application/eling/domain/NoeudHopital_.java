package application.eling.domain;

import application.eling.domain.Employe;
import application.eling.domain.NoeudHopital;
import application.eling.domain.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-11T18:45:19")
@StaticMetamodel(NoeudHopital.class)
public class NoeudHopital_ { 

    public static volatile ListAttribute<NoeudHopital, NoeudHopital> noeudsInferieurs;
    public static volatile SingularAttribute<NoeudHopital, Patient> patient;
    public static volatile SingularAttribute<NoeudHopital, Employe> chef;
    public static volatile SingularAttribute<NoeudHopital, Integer> id;
    public static volatile SingularAttribute<NoeudHopital, Integer> niveau;

}