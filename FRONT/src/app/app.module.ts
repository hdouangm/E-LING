import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ScrollSpyDirective } from './scroll-spy.directive';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Route} from '@angular/router';
import { CompteAphpAddingComponent } from './compteAphpAdding/compteAphpAdding.component';
import { CompteAphpSearchingComponent } from './compteAphpSearching/compteAphpSearching.component';
import { DemandeInterventionAddingComponent } from './demandeInterventionAdding/demandeInterventionAdding.component';
import { DemandeExamenAddingComponent } from './demandeExamenAdding/demandeExamenAdding.component';
import { DetailPatientComponent } from './detail-patient/detail-patient.component';
import { ListPatientComponent } from './list-patient/list-patient.component';
import { CoderActeComponent } from './coder-acte/coder-acte.component';
import { ModifierProfilComponent} from './modifier-profil/modifier-profil.component';
import { AccederDmpComponent} from './acceder-dmp/acceder-dmp.component';
import { DeconnexionComponent } from './deconnexion/deconnexion.component';
import { DemandeExamenListMedComponent} from './demande-examen-list-med/demande-examen-list-med.component';
import {DemandeExamenListLabComponent} from './demande-examen-list-lab/demande-examen-list-lab.component';
import {DemandeInterventionListLabComponent} from './demande-intervention-list-lab/demande-intervention-list-lab.component';
import {DemandeInterventionListMedComponent} from './demande-intervention-list-med/demande-intervention-list-med.component';
import {FinderComponent} from './finder/finder.component';
import {ListDmpComponent} from './list-dmp/list-dmp.component';
import { AuthGuard } from './auth.guard';
import {NewPatientDeuxComponent} from './new-patient2/new-patient.component';
import { InterventionComponent } from './intervention/intervention.component';
import { ExamenDetailComponent } from './examen/examen-detail/examen-detail.component';
import { ExamenComponent } from './examen/examen.component';
import {FilterNamePipe} from './list-patient/filter-name.pipe';
import { InterventionDetailComponent } from './intervention/intervention-detail/intervention-detail.component';
import { PosologieComponent } from './posologie/posologie.component';
import { PosologieDetailComponent } from './posologie/posologie-detail/posologie-detail.component';
import { DiagnostiqueComponent } from './diagnostique/diagnostique.component';
import { DiagnostiqueDetailComponent } from './diagnostique/diagnostique-detail/diagnostique-detail.component';
import { AgendaComponent } from './agenda/agenda.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DxSchedulerModule} from 'devextreme-angular';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import { InViewportModule } from '@thisissoon/angular-inviewport';
import { ScrollSpyModule } from '@thisissoon/angular-scrollspy';
const routelist: Route[] = [
  { path: '', redirectTo: 'connexion', pathMatch: 'full' },

  {path: 'connexion', component: ConnexionComponent},
  {path: 'coder-acte', component: CoderActeComponent},
  {path: 'deconnexion', component: DeconnexionComponent},
  {path:  'addingCompteAphp', component:  CompteAphpAddingComponent },
  {path:  'searchCompteAphp', component:  CompteAphpSearchingComponent },
  {path:  'addDemandeExamen', component:  DemandeExamenAddingComponent},
  {path:  'addDemandeIntervention', component:  DemandeInterventionAddingComponent },
  {path:  'demandeExamen', component:  DemandeExamenListMedComponent },
  {path : 'listePatient', component : ListPatientComponent, canActivate: [AuthGuard] },
  {path : 'modifierProfil/:id', component: ModifierProfilComponent},
  {path : 'accederDMP/:id', component: AccederDmpComponent},
  {path : 'deconnexion', component: DeconnexionComponent},
  {path : 'InterventionListMed', component: DemandeInterventionListMedComponent},
  {path: 'newPatient2', component: NewPatientDeuxComponent},
  {path: 'examen', component: ExamenComponent},
  {path: 'afficherExam', component: ExamenDetailComponent},
  {path: 'agenda', component: AgendaComponent}

];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ConnexionComponent,
    CompteAphpAddingComponent,
    CompteAphpSearchingComponent,
    DemandeInterventionAddingComponent,
    DemandeExamenAddingComponent,
    ScrollSpyDirective,
    CoderActeComponent,
    ListPatientComponent,
    DetailPatientComponent,
    AccederDmpComponent,
    ModifierProfilComponent,
    DeconnexionComponent,
    DemandeExamenListLabComponent,
    DemandeExamenListMedComponent,
    DemandeInterventionListLabComponent,
    DemandeInterventionListMedComponent,
    FinderComponent,
    ListDmpComponent,
    NewPatientDeuxComponent,
    InterventionComponent,
    ExamenComponent,
    ExamenDetailComponent,
    FilterNamePipe,
    InterventionDetailComponent,
    PosologieComponent,
    PosologieDetailComponent,
    DiagnostiqueComponent,
    DiagnostiqueDetailComponent,
    AgendaComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(routelist),
    FormsModule,
    BrowserAnimationsModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    }),
    DxSchedulerModule,
    InViewportModule, ScrollSpyModule.forRoot()


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
