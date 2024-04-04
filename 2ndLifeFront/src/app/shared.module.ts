import { NgModule } from "@angular/core";
import { LoginComponent } from "./auth/components/login/login.component";
import { SignupComponent } from "./auth/components/signup/signup.component";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// shared.module.ts
@NgModule({
    declarations: [
      // Declare shared components, directives, pipes, etc.
      LoginComponent,
      SignupComponent,
      // Other shared elements...
    ],
    exports: [
      // Export shared components, directives, pipes, etc.
      LoginComponent,
      SignupComponent,
      // Other shared elements...
    ],
    imports: [
      CommonModule,
      ReactiveFormsModule,
      FormsModule
      // Other modules needed for shared elements...
    ]
  })
  export class SharedModule { }