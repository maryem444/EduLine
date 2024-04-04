import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../../components/home/home.component';
import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { AddTeacherComponent } from '../admin/components/add-teacher/add-teacher.component';
import { CoursesListComponent } from './components/courses-list/courses-list.component';
import { TeamComponent } from './components/teachers-list/team.component';
import { LoginComponent } from 'src/app/auth/components/login/login.component';
import { MyEnrollmentsComponent } from './components/my-enrollments/my-enrollments.component';


const routes: Routes = [
  {path:"dashboard", component:CustomerDashboardComponent},
  {path:"courses", component:CoursesListComponent},
  {path:"teachers", component:TeamComponent},
  {path:"login", component:LoginComponent },
  {path:"my_enroll", component:MyEnrollmentsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
