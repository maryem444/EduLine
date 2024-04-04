import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './auth/components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/components/login/login.component';

const routes: Routes = [
  {path:"signup", component:SignupComponent},
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"admin", loadChildren: () => import("./modules/admin/admin.module").then(m=> m.AdminModule)},
  {path:"customer", loadChildren: () => import("./modules/customer/customer.module").then(m=> m.CustomerModule)},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
