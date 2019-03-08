package application.eling.domain;

import application.eling.domain.CompteAphp;
import application.eling.domain.DonneesSociales;
import application.eling.domain.NoeudHopital;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-08T17:29:52")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, List> competences;
    public static volatile SingularAttribute<Employe, NoeudHopital> noeudHopital;
    public static volatile SingularAttribute<Employe, CompteAphp> compteAphp;
    public static volatile SingularAttribute<Employe, Integer> id;
    public static volatile SingularAttribute<Employe, DonneesSociales> donneesSociales;
    public static volatile SingularAttribute<Employe, Integer> niveau;

}