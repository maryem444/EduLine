import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-dash',
  templateUrl: './admin-dash.component.html',
  styleUrls: ['./admin-dash.component.css']
})
export class AdminDashComponent implements OnInit {

  courses: any =[];
  message: any;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private adminService:AdminService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
    this.getAllCourses();
  }

  getAllCourses() {
    this.adminService.getAllCourses().subscribe(
      (res) => {
        console.log(res);
        this.courses = res; // Assign the received courses to the local array
      },
      (error) => {
        console.error('Error getting courses', error);
      }
    );
  }
  

  deleteCourse(id: number) {
    console.log(id);
    this.adminService.deleteCourse(id).subscribe(
      () => {
        // Remove the deleted teacher from the local array
        this.courses = this.courses.filter((c: { id: any; }) => c.id !== id);
      },
      error => {
      }
    );
  }

}
