import { Routes } from '@angular/router';
import { ConfigFormComponent } from './admin/config-form/config-form.component';
import { InscriptionComponent } from './inscription/inscription.component';

export const routes: Routes = [
{ path: '', redirectTo: '/admin/config', pathMatch: 'full' } ,
{ path: 'admin/config', component: ConfigFormComponent },
{ path: 'inscription', component: InscriptionComponent }

];
