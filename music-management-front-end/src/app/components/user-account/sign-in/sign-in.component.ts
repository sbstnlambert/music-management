import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  signInForm!: FormGroup;

  constructor(
    private router: Router,
    private authService: AuthService
  ) {
    this.signInForm = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      password: new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
  }

  onSignIn(): void {
    if (this.signInForm.valid) {
      if (this.authService.verifyUserAccountAndSignIn(this.signInForm.value)) {
        this.router.navigate(['']);
      } else {
        alert('Username and/or password incorrect');
      }
    } else {
      console.log('Invalid form');
    }
  }

  onSignUp(): void {
    this.router.navigate(["signup"]);
  }

}
