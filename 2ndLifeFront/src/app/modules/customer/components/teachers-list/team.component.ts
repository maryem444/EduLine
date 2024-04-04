import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  teachers: any =[];

  constructor(
    private service: CustomerService,
    private fb: FormBuilder,
    private router: Router,
    private sanitizer: DomSanitizer,

  ) { }

  ngOnInit() {
    this.getAllTeachers();
  }

  getAllTeachers(){
    this.service.getAllTeachers().subscribe((res)=>{
      console.log(res); 
      res.forEach((element: { processedImg: string; returnedImage: string; }) => {
        element.processedImg ='data:image/jpeg;base64,' + element.returnedImage;
        this.teachers.push(element);
      });
    })
  }

}
