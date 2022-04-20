import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm!: FormGroup;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.signUpForm = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.maxLength(30)]),
      password: new FormControl(null, Validators.required),
      email: new FormControl(null, [Validators.required, Validators.email])
    });
  }

  ngOnInit(): void {
  }

  onSignUp(): void {
    if (this.signUpForm.valid) {
      this.authService.signUp(this.signUpForm.value).subscribe({
        next: authUser => {
          if (authUser) {
            this.router.navigate(['']);
          } else {
            alert(`The username ${this.signUpForm.value['username']} is already used`);
          }
        },
        error: () => console.log('An error has occured during communication with the back-end service')
      });
    } else {
      alert('Invalid form');
    }
  }

}
