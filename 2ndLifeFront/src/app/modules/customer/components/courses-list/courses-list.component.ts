import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { StorageService } from 'src/app/storage/storage.service';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.css']
})
export class CoursesListComponent implements OnInit {

  isCustomerLoggedIn:boolean=StorageService.isCustomerLoggedIn();
  courses: any =[];
  enroll:any={};
  courseId: number = this.activatedRoute.snapshot.params["id"];
  message: any;

  constructor(
    private service: CustomerService,
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getAllCourses();
  }

  getAllCourses() {
    this.service.getAllCourses().subscribe(
      (res) => {
        console.log(res);
        this.courses = res; // Assign the received courses to the local array
      },
      (error) => {
        console.error('Error getting courses', error);
      }
    );
  }

  enrollCourse(courseId: number) {
    console.log(courseId);
    if (this.isCustomerLoggedIn) {
      let enrollCourseDto = {
        userId: StorageService.getUserId(),
        courseId: courseId
      }
      //console.log(this.enroll);
      this.service.enrollCourse(enrollCourseDto).subscribe((res)=>{
        console.log(res);
        this.router.navigateByUrl("/customer/dashboard")
        
      }, error => {
      });        
    }
    else{
    this.router.navigate(['/customer/login']);
    }
    
    
    
  }

}


