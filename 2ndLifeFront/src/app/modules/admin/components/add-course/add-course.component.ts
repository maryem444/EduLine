import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { TeacherService } from 'src/app/services/teacher-service.service';


@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  courseForm!: FormGroup;
  message: any;
startDate: any;
  constructor(
    private fb: FormBuilder,
    private teacherService: TeacherService,
    private router: Router,
    private sanitizer: DomSanitizer,
    private adminService: AdminService,
  ) { }

  ngOnInit() {
    this.courseForm = this.fb.group({
      courseTitle: ['', [Validators.required]],
      coursePrice: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      duration: ['', [Validators.required]]
    });
  }

  addCourse() {
    console.log(this.courseForm.value);

    this.adminService.addCourse(this.courseForm.value).subscribe((res)=>{
        this.router.navigateByUrl("/admin/dash");
        console.log(res);
    }, error => {
        console.log(error);
        
    });
  }


}
