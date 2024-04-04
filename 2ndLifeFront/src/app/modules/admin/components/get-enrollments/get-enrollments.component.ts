import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { StorageService } from 'src/app/storage/storage.service';

@Component({
  selector: 'app-get-enrollments',
  templateUrl: './get-enrollments.component.html',
  styleUrls: ['./get-enrollments.component.css']
})
export class GetEnrollmentsComponent implements OnInit {

  enrollments: any;
  message: any;

  constructor(
    private adminService : AdminService,
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private storageService: StorageService 
    ) { 
      this.getEnrollments()
    }

  ngOnInit() {
  
  }

  getEnrollments(){
    this.adminService.getCourseEnrollments().subscribe((res) => {
      console.log(res);
      this.enrollments = res;
    })
  }

  changeEnrollmentStatus(enrollmentId: number, status: string){
    console.log(enrollmentId, status);
    this.adminService.changeEnrollmentStatus(enrollmentId, status).subscribe((res) =>{
      console.log(res);
      this.getEnrollments();
    }, error => {
    })
  }
}
