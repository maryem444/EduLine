import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../storage/storage.service';


const customerUrl = 'http://localhost:8083';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient, private storageService: StorageService  // Assurez-vous que StorageService est injecté ici
  ) { }

  getAllCourses(): Observable<any>{
    return this.httpClient.get(customerUrl + "/api/customer/courses");
  }

  getCourseById(courseId:number): Observable<any>{
    return this.httpClient.get(customerUrl + "/api/customer/course/" + courseId );
  }

  enrollCourse(enrollCourseDto: any): Observable<any>{
    console.log(enrollCourseDto);
    
    return this.httpClient.post(customerUrl + "/api/customer/course/enroll" , enrollCourseDto );
  }

  getAllTeachers(): Observable<any>{
    return this.httpClient.get(customerUrl + "/api/customer/teachers");
  }

  getEnrollmentsByUserId(): Observable<any>{
    //const userId = StorageService.getUserId();
    return this.httpClient.get(customerUrl + "/api/customer/course/enrollments/" + StorageService.getUserId());
    console.log(StorageService.getUserId())

  }
  
}
