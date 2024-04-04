import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';

import { CustomerDashboardComponent } from './components/customer-dashboard/customer-dashboard.component';
import { AboutComponent } from './components/about/about.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { BannerComponent } from './components/banner/banner.component';
import { BlogComponent } from './components/blog/blog.component';
import { CallToActionComponent } from './components/call-to-action/call-to-action.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ClassStartComponent } from './components/class-start/class-start.component';
import { FacilitiesComponent } from './components/facilities/facilities.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { TeamComponent } from './components/teachers-list/team.component';
import { TestimonialComponent } from './components/testimonial/testimonial.component';
import { CoursesListComponent } from './components/courses-list/courses-list.component';

import { SharedModule } from 'src/app/shared.module';
import { MyEnrollmentsComponent } from './components/my-enrollments/my-enrollments.component';

@NgModule({
  declarations: [
    CustomerDashboardComponent,
    AboutComponent,
    AppointmentComponent,
    BannerComponent,
    BlogComponent,
    CallToActionComponent,
    CarouselComponent,
    ClassStartComponent,
    FacilitiesComponent,
    RegistrationComponent,
    TeamComponent,
    TestimonialComponent,
    CoursesListComponent,
    MyEnrollmentsComponent,

  ],
  exports: [
    AboutComponent,
    AppointmentComponent,
    BannerComponent,
    BlogComponent,
    CallToActionComponent,
    CarouselComponent,
    ClassStartComponent,
    FacilitiesComponent,
    RegistrationComponent,
    TeamComponent,
    TestimonialComponent    
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    SharedModule 
   ],
  // schemas: [CUSTOM_ELEMENTS_SCHEMA], // Add this line

})
export class CustomerModule { }
