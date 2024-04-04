import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
// import { NzMessageContainerComponent, NzMessageService } from 'ng-zorro-antd';
import { UserJwtService } from 'src/app/services/user-jwt.service';
import { StorageService } from 'src/app/storage/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  invalidLogin!: boolean;
  loginForm!: FormGroup;

  constructor(
    private userService: UserJwtService,
    private router: Router,
    private formBuilder: FormBuilder,
    // private message: NzMessageService
  ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ["", [Validators.email, Validators.required]],
      password: ["", [Validators.maxLength(20), Validators.required]],
    });
  }

  login() {
    console.log(this.loginForm.value);
    this.userService.login(this.loginForm.value).subscribe((res)=>{
      console.log(res);
      if (res.userId != null) {
        const user = {
          id: res.userId,
          role: res.userRole
        }
        StorageService.saveUser(user);
        if(StorageService.isAdminLoggedIn()){
          this.router.navigateByUrl("/admin/dashboard")
        }else if (StorageService.isCustomerLoggedIn()){
          this.router.navigateByUrl("/customer/dashboard")
        }else{
          console.log("Bad credentials");
        }
      }
    });
    }
  /*
    const formData = this.loginForm.value;
  
    this.userService.login(formData).subscribe(
      (data) => {
        if (data) {
          window.sessionStorage.setItem('token', data.token);
          window.sessionStorage.setItem('username', data.username);
          // Redirigez l'utilisateur vers une autre page après la connexion
          this.router.navigate(['admin']);
          console.log("Success");
          console.log("Data:", data);
        }
      },
      (error) => {
        console.log('Error:', error);
        this.invalidLogin = true; // Activez cette variable pour afficher un message d'erreur dans le template
      }
    );
  }*/
  
}
