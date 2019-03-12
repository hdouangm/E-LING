import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';

import { ApiService } from 'src/app/api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private apiService: ApiService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) {
    if (!this.apiService.isLoggedIn()) {
      this.router.navigate(['connexion']);
    }
    return this.apiService.isLoggedIn();
  }
  connexionActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) {
    if (this.apiService.isLoggedIn()) {
      this.router.navigate(['EmploisDuTemps']);
    }
    return this.apiService.isLoggedIn();

  }



}
