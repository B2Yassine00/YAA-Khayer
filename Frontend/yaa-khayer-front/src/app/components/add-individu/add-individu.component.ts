import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Addindivresponse } from 'src/app/entities/addindivresponse';
import { RegisterResponse } from 'src/app/entities/register-response';
import { Utilisateur } from 'src/app/entities/utilisateur';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

const API_URL="http://localhost:8000/demo/hello";

@Component({
  selector: 'app-add-individu',
  templateUrl: './add-individu.component.html',
  styleUrls: ['./add-individu.component.css']
})
export class AddIndividuComponent implements OnInit {
  
  individuGroupForm!: FormGroup;
  addindivResponse!: Addindivresponse;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  utilisateur!:Utilisateur;

  constructor(private httpClient: HttpClient,
              private userService: UtilisateurService,
              private formBuilder: FormBuilder,
              private tokenStorage: TokenStorageService,
              private authService: AuthService){}
  
  ngOnInit(): void {
    this.individuGroupForm = this.formBuilder.group({
      nom: [''],
      prenom: [''],
      numero: ['']
});
  }

  onSubmit(){
    this.addindivResponse= JSON.parse(JSON.stringify(this.individuGroupForm.value));
    console.log(this.addindivResponse);
    if(this.addindivResponse.nom!==null && this.addindivResponse.prenom!==null && this.addindivResponse.numero!==null){
      console.log(this.tokenStorage.getUser().id);
      this.utilisateur=new Utilisateur(+this.tokenStorage.getUser().id);
      this.authService.addindiv(this.utilisateur,this.addindivResponse.nom,this.addindivResponse.prenom,this.addindivResponse.numero).subscribe({
        next:data=>{
          console.log(data);
        },
        
        error: err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;         
        }
      })
    }
  }

}
