import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginResponse } from 'src/app/entities/login-response';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  LoginFormGroup!: FormGroup;
  loginResponse!: LoginResponse;

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  
  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private router: Router){}

  ngOnInit(): void {
    this.LoginFormGroup=this.formBuilder.group({
      username: [''],
      password: ['']
    });

  }

  onSubmit(){

    this.loginResponse = JSON.parse(JSON.stringify(this.LoginFormGroup.value));
    console.log(this.loginResponse);
    this.authService.login(this.loginResponse.username, this.loginResponse.password).subscribe({
      next: data => {
        console.log(data);
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().role;
        console.log(this.tokenStorage.getUser().role);
        this.router.navigateByUrl("/add-individu");
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });

    

  }

  reloadPage(): void {
    window.location.reload();
  }


}
