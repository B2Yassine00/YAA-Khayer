import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AddAssocResponse } from 'src/app/entities/add-assoc-response';
import { Addindivresponse } from 'src/app/entities/addindivresponse';
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
  addindivResponse!: Addindivresponse;
  addassocResponse!: AddAssocResponse;
  registryType: string ='notype';
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private router: Router,
              private tokenStorage: TokenStorageService) { }
  
  ngOnInit(): void {
    this.registerGroupForm=this.formBuilder.group({
      user: this.formBuilder.group({    
              username: [''],
              email: [''],
              role: [''],
              password: ['']}),
      individu : this.formBuilder.group({
              nom: [''],
              prenom: [''],
              numero: ['']
      }), 
      association : this.formBuilder.group({
        justification: ['']
      })

    });
  }

  completeRegistry(value: string){
      this.registryType = value;
      console.log(this.registryType);
      this.registerGroupForm.controls['individu'].reset();
      this.registerGroupForm.controls['association'].reset();
  }

  onSubmit(){

    this.registerResponse = JSON.parse(JSON.stringify(this.registerGroupForm.controls['user'].value));
    console.log(this.registerResponse);

    if(this.registerResponse.email!=="" && this.registerResponse.username!=="" && this.registerResponse.password!==""){

          if(this.registerResponse.role=="individu"){
            this.addindivResponse = JSON.parse(JSON.stringify(this.registerGroupForm.controls['individu'].value));
            console.log(this.addindivResponse);
            
            if(this.addindivResponse.nom!==""&&this.addindivResponse.numero!==""&&this.addindivResponse.prenom!==""){
                  this.authService.registerIndividu(this.registerResponse.username,
                                                    this.registerResponse.email,
                                                    this.registerResponse.role,
                                                    this.registerResponse.password,
                                                    this.addindivResponse.prenom,
                                                    this.addindivResponse.nom,
                                                    +this.addindivResponse.numero).subscribe({
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
          }

          }else if(this.registerResponse.role=="association"){
              this.addassocResponse = JSON.parse(JSON.stringify(this.registerGroupForm.controls['association'].value));
              console.log(this.addassocResponse);
              
              if(this.addassocResponse.justification!==""){
                this.authService.registerAssociation(this.registerResponse.username,
                  this.registerResponse.email,
                  this.registerResponse.role,
                  this.registerResponse.password,
                  this.addassocResponse.justification).subscribe({
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
                  })
              }
          }
  }
  else{
    window.location.reload();
  }
  }

}
