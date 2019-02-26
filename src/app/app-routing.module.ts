import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompteAphpAddingComponent } from './compteAphpAdding/compteAphpAdding.component';
import { CompteAphpSearchingComponent } from './compteAphpSearching/compteAphpSearching.component';
import { DemandeInterventionAddingComponent } from './demandeInterventionAdding/demandeInterventionAdding.component';
import { DemandeExamenAddingComponent } from './demandeExamenAdding/demandeExamenAdding.component';
import { DemandeExamenListLabComponent } from './demande-examen-list-lab/demande-examen-list-lab.component';
import { DemandeExamenListMedComponent } from './demande-examen-list-med/demande-examen-list-med.component';
import { DemandeInterventionListMedComponent } from './demande-intervention-list-med/demande-intervention-list-med.component';
import { DemandeInterventionListLabComponent } from './demande-intervention-list-lab/demande-intervention-list-lab.component';


const routes: Routes = [
  { path:  '', redirectTo:  'searchCompteAphp', pathMatch:  'full' },
  {path:  'addingCompteAphp', component:  CompteAphpAddingComponent },
  {path:  'searchCompteAphp', component:  CompteAphpSearchingComponent },
  {path:  'addDemandeExamen', component:  DemandeExamenAddingComponent },
  {path:  'addDemandeIntervention', component:  DemandeInterventionAddingComponent },
  {path:  'demandeExamenMed', component:  DemandeExamenListMedComponent },
  {path:  'demandeExamenLab', component:  DemandeExamenListLabComponent },
  {path:  'demandeInterventionMed', component:  DemandeInterventionListMedComponent },
  {path:  'demandeInterventionLab', component:  DemandeInterventionListLabComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}


