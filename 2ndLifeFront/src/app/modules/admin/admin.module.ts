import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './components/admin-dashboard/admin.component';
import { AddTeacherComponent } from './components/add-teacher/add-teacher.component';
import { UpdateTeacherComponent } from './components/update-teacher/update-teacher.component';
import { AddCourseComponent } from './components/add-course/add-course.component';
import { UpdateCourseComponent } from './components/update-course/update-course.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { GetEnrollmentsComponent } from './components/get-enrollments/get-enrollments.component';


@NgModule({
  declarations: [
    AdminComponent,
    AddTeacherComponent,
    UpdateTeacherComponent,
    AddCourseComponent,
    AddCourseComponent,
    UpdateCourseComponent,
    AdminDashComponent,
    GetEnrollmentsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  exports: [AddTeacherComponent],
})
export class AdminModule { }
