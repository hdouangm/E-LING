package application.eling.domain;

import application.eling.domain.Competence;
import application.eling.domain.CompteAphp;
import application.eling.domain.DonneesSociales;
import application.eling.domain.Examen;
import application.eling.domain.NoeudHopital;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T01:37:09")
=======
@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-25T00:46:39")
>>>>>>> 1c1caa06de7d72513fab171e0d734f68be193887
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SetAttribute<Employe, Competence> competences;
    public static volatile SingularAttribute<Employe, NoeudHopital> noeudHopital;
    public static volatile SingularAttribute<Employe, CompteAphp> compteAphp;
    public static volatile SingularAttribute<Employe, Examen> examen;
    public static volatile SingularAttribute<Employe, Integer> id;
    public static volatile SingularAttribute<Employe, DonneesSociales> donneesSociales;
    public static volatile SingularAttribute<Employe, Integer> niveau;

}