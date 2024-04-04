import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TeacherService } from 'src/app/services/teacher-service.service';
import { DomSanitizer } from '@angular/platform-browser';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-add-teacher',
  templateUrl: './add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit {
  teacherForm!: FormGroup;
  selectedFile!: File | null;
  imagePreview!: string | ArrayBuffer | null;
  message: any;


  constructor(
    private fb: FormBuilder,
    private teacherService: TeacherService,
    private router: Router,
    private sanitizer: DomSanitizer,
    private adminService:AdminService,
  ) { }

  ngOnInit() {
    this.teacherForm = this.fb.group({
      fullName: ['', [Validators.minLength(4), Validators.required]],
      speciality: ['', [Validators.minLength(3), Validators.required]],
      experience: ['', [Validators.minLength(4), Validators.required]]
    });
  }

  addTeacher() {
    console.log(this.teacherForm?.value);
    const formData: FormData = new FormData();
    console.log(this.selectedFile);

    if (this.selectedFile) {
        formData.append('image', this.selectedFile);
    }

    formData.append('fullName', this.teacherForm?.get('fullName')?.value);
    formData.append('speciality', this.teacherForm?.get('speciality')?.value);
    formData.append('experience', this.teacherForm?.get('experience')?.value);
    console.log(formData);

    this.adminService.addTeacher(formData).subscribe(
      (res) => {
        this.router.navigateByUrl("/admin/dashboard");
        if (res && res.success) {
          console.log(res);
        } 
      },
      (error) => {

      }
  );
  
}

onFileSelected(event: any) {
    if (event.target.files.length > 0) {
        this.selectedFile = event.target.files[0];
        this.previewImage();
    }
}

previewImage() {
    if (this.selectedFile) {
        const reader = new FileReader();
        reader.onload = () => {
            this.imagePreview = reader.result as string;
        }
        reader.readAsDataURL(this.selectedFile);
    }
}

}
