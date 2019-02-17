import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompteAphpListComponent } from './compteAphpList/compteAphpList.component';
import { CompteAphpAddingComponent } from './compteAphpAdding/compteAphpAdding.component';
import { CompteAphpSearchingComponent } from './compteAphpSearching/compteAphpSearching.component';
import { DemandeInterventionAddingComponent } from './demandeInterventionAdding/demandeInterventionAdding.component';
import { DemandeExamenAddingComponent } from './demandeExamenAdding/demandeExamenAdding.component';
import { DemandeExamenListComponent } from './demandeExamenList/demandeExamenList.component';
import { DemandeInterventionListComponent } from './demandeInterventionList/demandeInterventionList.component';
import { DemandeExamenEditComponent } from './demandeExamenEdit/demandeExamenEdit.component';
import { DemandeInterventionEditComponent } from './demandeInterventionEdit/demandeInterventionEdit.component';


const routes: Routes = [
  { path:  '', redirectTo:  'searchCompteAphp', pathMatch:  'full' },
  {path:  'addingCompteAphp', component:  CompteAphpAddingComponent },
  {path:  'compteAphp', component:  CompteAphpListComponent },
  {path:  'searchCompteAphp', component:  CompteAphpSearchingComponent },
  {path:  'addDemandeExamen', component:  DemandeExamenAddingComponent },
  {path:  'addDemandeIntervention', component:  DemandeInterventionAddingComponent },
  {path:  'demandeExamen', component:  DemandeExamenListComponent },
  {path:  'demandeIntervention', component:  DemandeInterventionListComponent },
  {path:  'demandeExamenEdit/:id', component:  DemandeExamenEditComponent },
  {path:  'demandeInterventionEdit/:id', component:  DemandeInterventionEditComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}


