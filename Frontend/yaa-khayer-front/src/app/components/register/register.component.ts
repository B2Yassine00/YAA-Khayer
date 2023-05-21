import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegisterResponse } from 'src/app/entities/register-response';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  registerGroupForm!: FormGroup;
  registerResponse!: RegisterResponse;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) { }
  
  ngOnInit(): void {
    this.registerGroupForm=this.formBuilder.group({
          username: [''],
          email: [''],
          role: [''],
          password: ['']
    });
  }

  get username(){ return this.registerGroupForm.get('username');}
  get email(){ return this.registerGroupForm.get('email');}
  get password(){ return this.registerGroupForm.get('password');}
  get role(){return this.registerGroupForm.get('role');}

  onSubmit(){

    this.registerResponse = JSON.parse(JSON.stringify(this.registerGroupForm.value));
    console.log(this.registerResponse);

    this.authService.register(this.registerResponse.username,this.registerResponse.email,this.registerResponse.role,this.registerResponse.password).subscribe({
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
