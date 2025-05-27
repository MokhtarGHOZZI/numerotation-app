import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ConfigService } from '../../services/config.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-config-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './config-form.component.html',
  styleUrls: ['./config-form.component.css']

})



export class ConfigFormComponent implements OnInit {
  configForm!: FormGroup;

constructor(
  private fb: FormBuilder,
  private configService: ConfigService
) {}


  ngOnInit(): void {
    this.configForm = this.fb.group({
      configid: ['', Validators.required],
      rules: this.fb.array([]),
    });
    this.addRule(); 
  }

  get rules(): FormArray {
    return this.configForm.get('rules') as FormArray;
  }

  addRule() {
    this.rules.push(
      this.fb.group({
        field: ['', Validators.required],
        length: [''],
        prefix: [''],
        suffix: [''],
        orderIndex: ['', Validators.required],
        dateFormat: [''],
        valeurInitiale: ['']
      })
    );
  }

  removeRule(index: number) {
    this.rules.removeAt(index);
  }

  save() {
    if (this.configForm.valid) {
      this.configService.saveConfig(this.configForm.value).subscribe({
        next: () => alert('Configuration enregistrée avec succès !'),
        error: err => alert('Erreur lors de l’enregistrement: ' + err.message)
      });
    }
  }
 
}