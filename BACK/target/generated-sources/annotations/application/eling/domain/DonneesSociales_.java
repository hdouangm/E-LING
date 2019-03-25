package application.eling.domain;

import application.eling.domain.Employe;
import application.eling.domain.Patient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T01:37:09")
@StaticMetamodel(DonneesSociales.class)
public class DonneesSociales_ { 

    public static volatile SingularAttribute<DonneesSociales, String> ville;
    public static volatile SingularAttribute<DonneesSociales, Employe> employe;
    public static volatile SingularAttribute<DonneesSociales, Patient> patient;
    public static volatile SingularAttribute<DonneesSociales, String> adresse;
    public static volatile SingularAttribute<DonneesSociales, String> genre;
    public static volatile SingularAttribute<DonneesSociales, Integer> id;
    public static volatile SingularAttribute<DonneesSociales, String> codePostal;
    public static volatile SingularAttribute<DonneesSociales, String> nom;
    public static volatile SingularAttribute<DonneesSociales, String> prenom;
    public static volatile SingularAttribute<DonneesSociales, String> age;
    public static volatile SingularAttribute<DonneesSociales, String> pays;

}