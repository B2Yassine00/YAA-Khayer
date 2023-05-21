import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegisterResponse } from 'src/app/entities/register-response';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

const API_URL="http://localhost:8000/demo/hello";

@Component({
  selector: 'app-add-individu',
  templateUrl: './add-individu.component.html',
  styleUrls: ['./add-individu.component.css']
})
export class AddIndividuComponent implements OnInit {
  
  individuGroupForm!: FormGroup;
  registerResponse!: RegisterResponse;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private httpClient: HttpClient,
              private userService: UtilisateurService,
              private formBuilder: FormBuilder){}
  
  ngOnInit(): void {
    this.individuGroupForm = this.formBuilder.group({
      nom: [''],
      prenom: [''],
      numero: ['']
});
  }

  onSubmit(){}

}
