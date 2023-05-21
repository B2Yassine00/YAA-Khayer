import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  registerGroupForm!: FormGroup;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = ''

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) { }
  
  ngOnInit(): void {
    this.registerGroupForm=this.formBuilder.group({
          username: [''],
          email: [''],
          password: ['']
    });
  }

  get username(){ return this.registerGroupForm.get('username');}
  get email(){ return this.registerGroupForm.get('email');}
  get password(){ return this.registerGroupForm.get('password');}

  onSubmit(){
    console.log(this.registerGroupForm.value);
    let username=String(this.username);
    let email=this.email;
    let password=this.password;

    this.authService.register(String(username),String(email),String(password)).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    });

  }

}
