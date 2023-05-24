import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegisterResponse } from 'src/app/entities/register-response';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-add-association',
  templateUrl: './add-association.component.html',
  styleUrls: ['./add-association.component.css']
})
export class AddAssociationComponent implements OnInit{

  associationGroupForm!: FormGroup;
  registerResponse!: RegisterResponse;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private httpClient: HttpClient,
              private userService: UtilisateurService,
              private formBuilder: FormBuilder){}
  
  ngOnInit(): void {
  
    this.associationGroupForm = this.formBuilder.group({
      justification: ['']
});
  
  }
  
  onSubmit(){}

}
