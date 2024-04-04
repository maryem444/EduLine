import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin-dashboard/admin.component';
import { AddTeacherComponent } from './components/add-teacher/add-teacher.component';
import { UpdateTeacherComponent } from './components/update-teacher/update-teacher.component';
import { AddCourseComponent } from './components/add-course/add-course.component';
import { UpdateCourseComponent } from './components/update-course/update-course.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { GetEnrollmentsComponent } from './components/get-enrollments/get-enrollments.component';


const routes: Routes = [
  {path:"dashboard", component:AdminComponent},
  {path: "dash", component:AdminDashComponent},
  {path: "teacher", component:AddTeacherComponent},
  {path: "teacher/:id", component:UpdateTeacherComponent},
  {path:"course", component:AddCourseComponent},
  {path:"course/:id", component:UpdateCourseComponent},
  {path:"enrollments", component:GetEnrollmentsComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
