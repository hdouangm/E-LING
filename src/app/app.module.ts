import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompteAphpAddingComponent } from './compteAphpAdding/compteAphpAdding.component';
import { CompteAphpSearchingComponent } from './compteAphpSearching/compteAphpSearching.component';
import { DemandeInterventionAddingComponent } from './demandeInterventionAdding/demandeInterventionAdding.component';
import { DemandeExamenAddingComponent } from './demandeExamenAdding/demandeExamenAdding.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { DemandeExamenListLabComponent } from './demande-examen-list-lab/demande-examen-list-lab.component';
import { DemandeExamenListMedComponent } from './demande-examen-list-med/demande-examen-list-med.component';
import { DemandeInterventionListMedComponent } from './demande-intervention-list-med/demande-intervention-list-med.component';
import { DemandeInterventionListLabComponent } from './demande-intervention-list-lab/demande-intervention-list-lab.component';

@NgModule({
  declarations: [
    AppComponent,
    CompteAphpAddingComponent,
    CompteAphpSearchingComponent,
    DemandeInterventionAddingComponent,
    DemandeExamenAddingComponent,
    HeaderComponent,
    MenuComponent,
    DemandeExamenListLabComponent,
    DemandeExamenListMedComponent,
    DemandeInterventionListMedComponent,
    DemandeInterventionListLabComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
