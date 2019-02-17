import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompteAphpListComponent } from './compteAphpList/compteAphpList.component';
import { CompteAphpAddingComponent } from './compteAphpAdding/compteAphpAdding.component';
import { CompteAphpSearchingComponent } from './compteAphpSearching/compteAphpSearching.component';
import { DemandeInterventionAddingComponent } from './demandeInterventionAdding/demandeInterventionAdding.component';
import { DemandeExamenAddingComponent } from './demandeExamenAdding/demandeExamenAdding.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { DemandeExamenListComponent } from './demandeExamenList/demandeExamenList.component';
import { DemandeInterventionListComponent } from './demandeInterventionList/demandeInterventionList.component';
import { DemandeExamenEditComponent } from './demandeExamenEdit/demandeExamenEdit.component';
import { DemandeInterventionEditComponent } from './demandeInterventionEdit/demandeInterventionEdit.component';

@NgModule({
  declarations: [
    AppComponent,
    CompteAphpListComponent,
    CompteAphpAddingComponent,
    CompteAphpSearchingComponent,
    DemandeInterventionAddingComponent,
    DemandeExamenAddingComponent,
    HeaderComponent,
    MenuComponent,
    DemandeInterventionListComponent,
    DemandeExamenListComponent,
    DemandeExamenEditComponent,
    DemandeInterventionEditComponent
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
