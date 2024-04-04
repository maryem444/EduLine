import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  /*teacherURL:string="http://localhost:8086/api/teachers";
  addteacherURL:string="http://localhost:8086/api/teachers/addTeacher";
  baseUrl:string="http://localhost:8086";
  public dataForm:  FormGroup; 

  constructor(private httpClient:HttpClient) { }
  getAllTeachers(){
    return this.httpClient.get(this.teacherURL);
  }

  getTeacherById(id){
    return this.httpClient.get(`${this.teacherURL}/${id}`)
  }

  deleteTeacher(id){
    return this.httpClient.delete(`${this.teacherURL}/${id}`);
  }

  readonly httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'multipart/form-data',
    }),
  };
  
  addTeacher(formData: FormData): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}`, formData);
}

prepareFormData(teacher: Teacher, imageFile: File): FormData {
  const formData = new FormData();

  // Assurez-vous que les noms 't' et 'teacherImage' correspondent à ceux attendus par le backend
  formData.append('t', JSON.stringify(teacher));
  formData.append('teacherImage', imageFile);

  return formData;
}


  editTeacher(teacher){
    return this.httpClient.put(`${this.teacherURL}/${teacher.id}`, teacher);
  }

  getName(){
    return this.httpClient.get(`${this.teacherURL}`);

  }

  createBasicAuthHttpHeader(){
    let username = 'crococoder';
    let password = 'a';
    // btoa to convert string to base 64
    let basicAuthHeader = 'Basic ' + window.btoa(username+':'+password);
    return basicAuthHeader;
  }
  uploadFile(file: File): Observable<HttpEvent<{}>> {
		const formdata: FormData = new FormData();
		formdata.append('file', file);
		const req = new HttpRequest('POST', '<Server URL of the file upload>', formdata, {
			  reportProgress: true,
			  responseType: 'text'
		});
	
		return this.httpClient.request(req);
   }*/
}
