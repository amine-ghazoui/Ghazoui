import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KeynotesComponent } from './components/keynotes/keynotes.component';
import { ConferenceListComponent } from './components/conference-list/conference-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';

const routes: Routes = [
  {path : "", component : KeynotesComponent},
  {path : "keynotes", component : KeynotesComponent},
  {path : "conferences", component : ConferenceListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
