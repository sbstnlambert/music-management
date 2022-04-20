import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserForm } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _username!: string;
  private _password!: string;
  private _isAuthenticated: boolean = false;
  private BASE_URL: string = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }

  public get username(): string {
    return this._username;
  }

  public get password(): string {
    return this._password;
  }

  public get isAuthenticated(): boolean {
    return this._isAuthenticated;
  }

  public verifyUserAccountAndSignIn(form: UserForm): boolean {
    this.http.post<boolean>(`${this.BASE_URL}/verify`, form).subscribe({
      next: userExists => this.signIn(userExists, form),
      error: () => {
        console.log('An error has occured during communication with the back-end service');
        this._isAuthenticated = false;
      }
    });

    return this._isAuthenticated;
  }

  private signIn(userExists: boolean, form: UserForm): void {
    if (userExists) {
      this._username = form.username;
      this._password = form.password;
    }
    this._isAuthenticated = userExists;
  }

  public signOut(): void {
    this._username = '';
    this._password = '';
    this._isAuthenticated = false;
  }
}
