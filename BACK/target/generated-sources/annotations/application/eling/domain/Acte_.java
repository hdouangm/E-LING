package application.eling.domain;

import application.eling.domain.Diagnostique;
import application.eling.domain.Examen;
import application.eling.domain.Intervention;
import application.eling.domain.Posologie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-03-28T16:36:08")
@StaticMetamodel(Acte.class)
public class Acte_ { 

    public static volatile SingularAttribute<Acte, Diagnostique> diagnostique;
    public static volatile SingularAttribute<Acte, Integer> prix;
    public static volatile SingularAttribute<Acte, String> description;
    public static volatile SingularAttribute<Acte, Examen> examen;
    public static volatile SingularAttribute<Acte, Posologie> posologie;
    public static volatile SingularAttribute<Acte, Integer> id;
    public static volatile SingularAttribute<Acte, Intervention> intervention;

}