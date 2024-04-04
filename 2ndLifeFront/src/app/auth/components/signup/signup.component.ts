import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit, Renderer2 } from '@angular/core';
import { UserJwtService } from 'src/app/services/user-jwt.service';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http'; // Importez HttpHeaders


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm!: FormGroup;
  messageSuccess: string | null = null;
  messageError: string | null = null;
  message: any;
  
  constructor(
    private fb: FormBuilder,
    private userService: UserJwtService,
    private router: Router,
    private renderer: Renderer2  // Add this line

  ) { }

  ngOnInit() {
    this.signupForm = this.fb.group({
      firstName: ['', [Validators.minLength(4), Validators.required]],
      lastName: ['', [Validators.minLength(3), Validators.maxLength(10), Validators.required]],
      email: ['', [Validators.email, Validators.required]],
      password: ['', [Validators.minLength(8), Validators.required]],
      confirmPwd: ''
    });
  }


  register() {
    console.log(this.signupForm.value);
    this.userService.register(this.signupForm.value).subscribe((res) => {
      console.log(res);
      if (res.id != null) {
        this.router.navigateByUrl("/login");
      } else {
      }
    });
  }
  
  


  
  /*signup2(x) {
    console.log('Here user', x);
  }

  addUser(user: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    this.userService.addUser(user).subscribe(
      () => {
        this.router.navigate(['home']);
      }
    );
  }
  
 signup(user) {
  this.addUser(user);
}*/
}
