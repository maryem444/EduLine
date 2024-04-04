import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  teachers: any =[];
  message: any;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,
    private adminService:AdminService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
    this.getAllTeachers();
  }

  getAllTeachers(){
    this.adminService.getAllTeachers().subscribe((res)=>{
      console.log(res); 
      res.forEach((element:any) => {
        element.processedImg ='data:image/jpeg;base64,' + element.returnedImage;
        this.teachers.push(element);
      });
    })
  }

  deleteTeacher(id: number) {
    console.log(id);
    this.adminService.deleteTeacher(id).subscribe(
      () => {
        // Remove the deleted teacher from the local array
        this.teachers = this.teachers.filter((t: { id: any; }) => t.id !== id);
      },
      error => {

      }
    );
  }
  

}
