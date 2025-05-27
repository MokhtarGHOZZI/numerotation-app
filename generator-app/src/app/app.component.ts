import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ConfigFormComponent } from './admin/config-form/config-form.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ConfigFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'generator-app';
}
