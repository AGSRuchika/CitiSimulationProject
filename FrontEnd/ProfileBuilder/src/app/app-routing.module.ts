import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { HeaderComponent } from './header/header.component';
import { CreateComponent } from './create/create.component';
import { HomeComponent } from './home/home.component';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { DialogComponent } from './dialog/dialog.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path:'login', component:LoginPageComponent},
  {path: 'header',component:HeaderComponent},
  {path: 'create',component:CreateComponent},
  {path: 'home',component:HomeComponent},
  {path: 'viewprofile',component:ViewprofileComponent},
  {path: 'dialog/:profileEmail',component:DialogComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
