import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  signInForm!: FormGroup;

  constructor(
    private router: Router
  ) {
    this.signInForm = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      password: new FormControl(null, Validators.required)
    });
  }

  ngOnInit(): void {
  }

  onSignIn(): void {

  }

  onSignUp(): void {
    this.router.navigate(["signup"]);
  }

}
