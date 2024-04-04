import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  courseId:number=this.activatedRoute.snapshot.params["id"];
  updateForm!: FormGroup;
  message: any;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private adminService:AdminService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.updateForm = this.fb.group({
      courseTitle: ['', [Validators.required]],
      coursePrice: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      duration: ['', [Validators.required]]
    })
    this.getCourseById();
  }

  getCourseById(){
    this.adminService.getCourseById(this.courseId).subscribe((res)=>{
      //console.log(res);

      const courseDto= res;
      console.log(courseDto);
      this.updateForm.patchValue(courseDto);
    })
  }

  updateCourse(){
    /*const formData: FormData = new FormData();
    formData.append('courseTitle', this.updateForm.get('courseTitle').value);
    formData.append('coursePrice', this.updateForm.get('coursePrice').value);
    formData.append('startDate', this.updateForm.get('startDate').value);
    formData.append('duration', this.updateForm.get('duration').value);
    console.log(formData);*/

    this.adminService.updateCourse(this.courseId, this.updateForm.value).subscribe((res)=>{
      this.router.navigateByUrl("/admin/dash");
      console.log(res);

    },error=>{
    })
  }

}
