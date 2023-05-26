import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterResponse } from 'src/app/entities/register-response';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

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
              private authService: AuthService,
              private router: Router,
              private tokenStorage: TokenStorageService) { }
  
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

    if(this.registerResponse.email!=="" && this.registerResponse.username!=="" && this.registerResponse.password!==""){

          this.authService.register(this.registerResponse.username,this.registerResponse.email,this.registerResponse.role,this.registerResponse.password).subscribe({
            next: data => {
              console.log(data);              
              this.tokenStorage.saveToken(data.token);
              this.tokenStorage.saveUser(data);
              console.log(this.tokenStorage.getUser().id)
              this.isSuccessful = true;
              this.isSignUpFailed = false;
            },
            error: err => {
              this.errorMessage = err.error.message;
              this.isSignUpFailed = true;
            }
          });

          if(this.registerResponse.role==="individu"){
              this.router.navigateByUrl("/add-individu");
          }
          else if (this.registerResponse.role==="association"){
            this.router.navigateByUrl("/add-association");
          }
  }
  else{
    window.location.reload();
  }
  }

}
