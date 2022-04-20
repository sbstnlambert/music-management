import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Injectable()
export class HeaderSettersInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(this.authService.isAuthenticated){
      request = request.clone({
        setHeaders:{
          'Content-Type' : 'application/json; charset=utf-8',
          'Accept'       : 'application/json',
          'Authorization': `Basic ${btoa(this.authService.username+":"+this.authService.password)}`
        }
      })
    }
    return next.handle(request);
  }
}
