import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { StorageService } from 'src/app/storage/storage.service';

@Component({
  selector: 'app-my-enrollments',
  templateUrl: './my-enrollments.component.html',
  styleUrls: ['./my-enrollments.component.css']
})
export class MyEnrollmentsComponent implements OnInit {

  enrollments: any;
  courses!: any[];

  constructor(
    private service: CustomerService,
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private storageService: StorageService  // Assurez-vous que StorageService est injecté ici
  ) { 
    this.getMyEnrollments();
  }

  ngOnInit() {
  }

  getMyEnrollments(){
    this.service.getEnrollmentsByUserId().subscribe((res)=>{
      console.log(res);
      this.enrollments = res;
    })
  }

  /*getAllCourses(){
    this.service.getAllCourses().subscribe((res) => {
      this.courses = res;
    });
  }*/

  enrollCourse(courseId: number) {
    /*if (this.isCustomerLoggedIn) {
      this.service.enrollCourse({ courseId: courseId }).subscribe((res) => {
        const enrolledCourse = res;
        this.courses.push(enrolledCourse);
      });
    }
    else{
      this.router.navigate(['/customer/login']);
    }*/
    console.log(courseId);
  }

  get isCustomerLoggedIn(): boolean {
    return false;
  }
}