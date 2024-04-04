import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FacilitiesComponent } from './modules/customer/components/facilities/facilities.component';
import { ClassStartComponent } from './modules/customer/components/class-start/class-start.component';
import { AboutComponent } from './modules/customer/components/about/about.component';
import { RegistrationComponent } from './modules/customer/components/registration/registration.component';
import { TeamComponent } from './modules/customer/components/teachers-list/team.component';
import { TestimonialComponent } from './modules/customer/components/testimonial/testimonial.component';
import { BlogComponent } from './modules/customer/components/blog/blog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppointmentComponent } from './modules/customer/components/appointment/appointment.component';
import { CallToActionComponent } from './modules/customer/components/call-to-action/call-to-action.component';
import { CarouselComponent } from './modules/customer/components/carousel/carousel.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './auth/components/signup/signup.component';
import { BannerComponent } from './modules/customer/components/banner/banner.component';
// import { IconsProviderModule } from './icons-provider.module';
// import { NgZorroAntdModule, NZ_I18N, fr_FR } from 'ng-zorro-antd';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import fr from '@angular/common/locales/fr';



import { HeaderComponent } from './components/header/header.component';
import { CustomerModule } from './modules/customer/customer.module';
import { SharedModule } from './shared.module';

registerLocaleData(fr);




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    
    FooterComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    // IconsProviderModule,
    CustomerModule,
    BrowserAnimationsModule,
    // NzSpinModule ,
    // NzFormModule ,
    // NzButtonModule,
    // NzInputModule ,
    // NzLayoutModule,
    // NzMessageModule,
    // CustomerModule,
    // SharedModule, 
  ],
  // providers: [{ provide: NZ_I18N, useValue: fr_FR }],
  bootstrap: [AppComponent],
 // schemas: [CUSTOM_ELEMENTS_SCHEMA], // Add this line

})
export class AppModule { }
