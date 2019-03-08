import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from 'src/app/api.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private apiService: ApiService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
     //   const currentUser: any = this.apiService.getEmployeConnecte();
        const token =  localStorage.getItem('ACCESS_TOKEN');
        console.log('JWTInterceptor : ', token);
        if (token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
        }


        return next.handle(request);
    }
}
