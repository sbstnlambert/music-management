import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { UserSignInForm, UserSignUpForm } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _username!: string;
  private _password!: string;
  private _isAuthenticated: boolean = false;
  private _userRoles!: Array<string>;
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

  public get userRoles(): Array<string> {
    return this._userRoles;
  }

  public verifyUserAccountAndSignIn(form: UserSignInForm): Observable<boolean> {
    return this.http.post<boolean>(`${this.BASE_URL}/verify`, form).pipe(
      tap({
        next: userExists => this.signIn(userExists, form)
      })
    );
  }

  private signIn(userExists: boolean, form: UserSignInForm): void {
    if (userExists) {
      this._username = form.username;
      this._password = form.password;
      this.http.get<Array<string>>(`${this.BASE_URL}/roles?user=${this._username}`).subscribe({
        next: roles => this._userRoles = roles,
        error: () => console.log('An error has occured during communication with the back-end service')
      });
    }
    this._isAuthenticated = userExists;
  }

  public signUp(form: UserSignUpForm): Observable<boolean> {
    return this.http.post<boolean>(`${this.BASE_URL}/add`, form).pipe(
      tap({
        next: userCreated => this.signIn(userCreated, form)
      })
    );
  }

  public signOut(): void {
    this._username = '';
    this._password = '';
    this._isAuthenticated = false;
  }
}
