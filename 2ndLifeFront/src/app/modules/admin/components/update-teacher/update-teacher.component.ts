import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-update-teacher',
  templateUrl: './update-teacher.component.html',
  styleUrls: ['./update-teacher.component.css']
})
export class UpdateTeacherComponent implements OnInit {

  teacherId:number=this.activatedRoute.snapshot.params["id"];
  existingImage: string | null = null;
  updateForm!: FormGroup;
  imgChanged: boolean = false;
  selectedFile:any;
  imagePreview!: string | ArrayBuffer | null;
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
      fullName: ['', [Validators.required]],
      speciality: ['', [Validators.required]],
      experience: ['', [Validators.required]]
    })
    this.getTeacherById();
  }

  getTeacherById(){
    this.adminService.getTeacherById(this.teacherId).subscribe((res)=>{
      //console.log(res);

      const teacherDto= res;
      this.existingImage = 'data:image/jpeg;base64,' + res.returnedImage;
      console.log(teacherDto);
      console.log(this.existingImage);
      this.updateForm.patchValue(teacherDto);
    })
  }

  updateTeacher(){
    const formData: FormData = new FormData();
    if(this.imgChanged && this.selectedFile){
      formData.append('image', this.selectedFile);
    }
    formData.append('fullName', this.updateForm.get('fullName')?.value || '');
    formData.append('speciality', this.updateForm.get('speciality')?.value || '');
    formData.append('experience', this.updateForm.get('experience')?.value || '');
    console.log(formData);

    this.adminService.updateTeacher(this.teacherId, formData).subscribe((res)=>{
      this.router.navigateByUrl("/admin/dashboard");
      console.log(res);

    },error=>{
    })
  }

  onFileSelected(event:any){
    this.selectedFile = event.target.files[0];
    this.imgChanged = true;
    this.existingImage = null ;
    this.previewImage();
  }

  previewImage(){
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    }
    reader.readAsDataURL(this.selectedFile);
  }

}
