import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfigService } from '../services/config.service';
import { GeneratorService } from '../services/generator.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-inscription',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent implements OnInit {
  inscriptionForm!: FormGroup;
  configurations: any[] = [];
  generatedNumber: string | null = null;

  constructor(
    private fb: FormBuilder,
    private generatorService: GeneratorService,
    private configService: ConfigService
  ) {}

  ngOnInit(): void {
    this.inscriptionForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      birthDate: [''],
      configid: ['']
    });

    this.configService.getAllConfigs().subscribe(configs => {
      this.configurations = configs;
    });
  }
submit() {
  const data = this.inscriptionForm.value;
  this.generatorService.generate(data).subscribe(res => {
    this.generatedNumber = res; // directement la chaîne
  });
}

}
