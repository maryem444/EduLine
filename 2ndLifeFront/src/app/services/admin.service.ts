import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const adminUrl = 'http://localhost:8083';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private httpClient: HttpClient) {}

  //Teacher_CRUD
  addTeacher(teacherDto: any): Observable<any> {
    return this.httpClient.post(adminUrl + "/api/admin/teacher", teacherDto);
  }

  getAllTeachers(): Observable<any>{
    return this.httpClient.get(adminUrl + "/api/admin/teachers");
  }

  deleteTeacher(id: number): Observable<any>{
    return this.httpClient.delete(adminUrl + "/api/admin/teacher/" + id);
  }

  getTeacherById(id: number): Observable<any>{
    return this.httpClient.get(adminUrl + "/api/admin/teacher/" + id);
  }

  updateTeacher(teacherId:number , teacherDto: any): Observable<any>{
    return this.httpClient.put(adminUrl + "/api/admin/teacher/" +  teacherId , teacherDto);
  }


  //Course_CRUD
  addCourse(courseDto: any): Observable<any> {
    return this.httpClient.post(adminUrl + "/api/admin/course", courseDto);
  }

  getAllCourses(): Observable<any>{
    return this.httpClient.get(adminUrl + "/api/admin/courses");
  }

  deleteCourse(id: number): Observable<any>{
    return this.httpClient.delete(adminUrl + "/api/admin/course/" + id);
  }

  getCourseById(id: number): Observable<any>{
    return this.httpClient.get(adminUrl + "/api/admin/course/" + id);
  }

  updateCourse(courseId:number , courseDto: any): Observable<any>{
    return this.httpClient.put(adminUrl + "/api/admin/course/" +  courseId , courseDto);
  }


  //ENROLLMENTS
  getCourseEnrollments(): Observable<any>{
    return this.httpClient.get(adminUrl + "/api/admin/course/enrollments");
  }

  changeEnrollmentStatus(enrollmentId:number, status:string): Observable<any>{
    return this.httpClient.get(`${adminUrl}/api/admin/course/enrollment/${enrollmentId}/${status}`);
  }
  
}
