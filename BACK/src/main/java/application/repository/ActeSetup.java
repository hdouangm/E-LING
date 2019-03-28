package application.repository;

import application.eling.domain.Acte;
import application.eling.domain.Examen;
import application.eling.domain.Intervention;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Startup
@Singleton
public class ActeSetup {

  @EJB
  private ActeRepository acterepository;

  @EJB
  private InterventionRepository interventionrepository;

  @PostConstruct
  private void createData() {
    Acte a = new Acte("Prélèvement par ponction biopsique du foie ou de la rate pour examen",100);
    Acte b = new Acte("Tubage pour études biologiques des liquides gastriques et duodénaux",80);
    Set<Acte> l = new HashSet<Acte>(0);
    acterepository.save(a);
    acterepository.save(b);
    l.add(a);
    l.add(b);
    
    acterepository.save(new Acte("Consultation", 20));
    acterepository.save(new Acte("Radiographie du thorax", 100));
    acterepository.save(new Acte("Chirurgie cardiovasculaire", 450));

    acterepository.save(new Acte("Nettoyage ou pansement d'une brûlure", 20));
    acterepository.save(new Acte("Prélèvement de peau suivi de suture pour examen histologique", 50));
    acterepository.save(new Acte("Ponction biopsique osseuse", 150));
    acterepository.save(new Acte("Ponction articulaire à l'aiguille ou au trocart", 160));
    acterepository.save(new Acte("Ponction artérielle percutanée", 140));
    acterepository.save(new Acte("Infiltrations percutanées", 60));
    acterepository.save(new Acte("Ponction isolée du sinus maxillaire", 200));
    acterepository.save(new Acte("Diathermo-coagulation d'une leucoplasie, d'un lupus ou d'une tumeur bénigne", 300));
    acterepository.save(new Acte("Pansement moyen ou pansements multiples sur un pied", 15));
    acterepository.save(new Acte("Pansement moyen ou pansements multiples sur deux pieds", 25));
    acterepository.save(new Acte("Pansement d'hygroma consécutif à l'intervention du médecin", 20));
    acterepository.save(new Acte("Massage d'un pied, en relation avec une intervention chirurgicale sur les avant-pieds", 20));
    acterepository.save(new Acte("Massage des deux pieds, en relation avec une intervention chirurgicale sur les avant-pieds", 30));
    acterepository.save(new Acte("Bilan musculaire des conséquences motrices des affections neurologiques", 70));

    acterepository.save(new Acte("Prélèvement par ponction veineuse directe", 250));
    acterepository.save(new Acte("Injection intraveineuse directe isolée", 105));
    acterepository.save(new Acte("Injection intraveineuse directe en série", 125));
    acterepository.save(new Acte("Injection intramusculaire", 120));
    acterepository.save(new Acte("Injection d'un implant souscutané", 95));
    acterepository.save(new Acte("Injection en goutte à goutte par voie rectale", 135));
    acterepository.save(new Acte("Pansements lourds et complexes nécessitant des conditions d'asepsie rigoureuse", 50));
    acterepository.save(new Acte("Pansement de stomie", 30));
    acterepository.save(new Acte("Ablation de fils ou d'agrafes,", 20));
    acterepository.save(new Acte("Pansement d'amputation nécessitant détersion, épluchage et régularisation", 80));
    acterepository.save(new Acte("Pansement chirurgical nécessitant un méchage ou une irrigation", 65));
    acterepository.save(new Acte("Pose de sonde gastrique", 130));
    acterepository.save(new Acte("Pulvérisation de produit(s) médicamenteux", 35));
    acterepository.save(new Acte("Réalisation de test tuberculinique", 70));
    acterepository.save(new Acte("Prélèvement sanguin sur cathéter veineux central extériorisé ou chambre implantable", 45));
    acterepository.save(new Acte("Injection intraveineuse par l'intermédiaire d'un cathéter central", 85));
    acterepository.save(new Acte("Dialyse péritonéale par cycleur", 170));



    interventionrepository.save(new Intervention(null, null,"lol",null,null,false,l,true, null));
  }
}
