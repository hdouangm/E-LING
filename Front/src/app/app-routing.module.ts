import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { DeconnexionComponent } from './deconnexion/deconnexion.component';
import { AccederDmpComponent } from './acceder-dmp/acceder-dmp.component';
import { ModifierProfilComponent } from './modifier-profil/modifier-profil.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  { path:  '', redirectTo:  'connexion', pathMatch:  'full' },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'modifierProfil/:id', component: ModifierProfilComponent, canActivate: [AuthGuard] },
  { path: 'accederDMP/:id', component: AccederDmpComponent, canActivate: [AuthGuard]  },
  { path: 'deconnexion', component: DeconnexionComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
