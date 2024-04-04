package com.example.perfectionnement.eduLine.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;
import com.example.perfectionnement.eduLine.services.admin.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin") 
@RequiredArgsConstructor
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//TEACHERRRR
	@PostMapping("/teacher")
	public ResponseEntity<?> addTeacher(@ModelAttribute TeacherDto teacherDto) throws IOException {
    	System.out.println("dkhalnelou");

		if (teacherDto.getImage() == null) {
	    	System.out.println("dkhalna fih");

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image cannot be null");
	        
	    }
		
	    boolean success = adminService.addTeacher(teacherDto);
	    if (success) {
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    } else {
	    	System.out.println("log");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}
	
	
	@GetMapping("/teachers")
	public ResponseEntity<?> getAllTeachers(){
    	System.out.println("hani dkhalt");

		return ResponseEntity.ok(adminService.getAllTeachers());

	}
	
	
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
		adminService.deleteTeacher(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
		TeacherDto teacherDto = adminService.getTeacherById(id);
		return ResponseEntity.ok(teacherDto);
	}
	
	
	@PutMapping("/teacher/{teacherId}")
	public ResponseEntity<Void> updateTeacher(@PathVariable Long teacherId, @ModelAttribute TeacherDto teacherDto) throws IOException{
		try {
			boolean success = adminService.updateTeacher(teacherId, teacherDto);
			if(success)return ResponseEntity.status(HttpStatus.OK).build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	/**********************************************************/
	//COURSEEEE
	@PostMapping("/course")
	public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto) throws IOException {
	    System.out.println("Received Course DTO: " + courseDto);

	    boolean success = adminService.addCourse(courseDto);
	    if (success) {
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    } else {
	    	System.out.println("logina");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}
	
	
	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourses(){
    	System.out.println("hani dkhalt lel course ");

		return ResponseEntity.ok(adminService.getAllCourses());

	}
	
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id){
		adminService.deleteCourse(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id){
		CourseDto courseDto = adminService.getCourseById(id);
		return ResponseEntity.ok(courseDto);
	}
	
	
	@PutMapping("/course/{courseId}")
	public ResponseEntity<Void> updateCourse(@PathVariable Long courseId, @RequestBody CourseDto courseDto) throws IOException{
		try {
			boolean success = adminService.updateCourse(courseId, courseDto);
			if(success)return ResponseEntity.status(HttpStatus.OK).build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

	   
	/**********************************************************/
	
	//Enrollments
	@GetMapping("/course/enrollments")
    public ResponseEntity<?> getEnrollments() {
        try {
            List<EnrollCourseDto> enrollments = adminService.getEnrollments();
            return ResponseEntity.ok(enrollments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve enrollments");
        }
    }
    
    @GetMapping("/course/enrollment/{enrollmentId}/{status}")
    public ResponseEntity<?> changeEnrollmentStatus(@PathVariable Long enrollmentId, @PathVariable String status) {
        try {
            boolean success = adminService.changeEnrollmentStatus(enrollmentId, status);
            if (success) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to change enrollment status");
        }
    }

}
