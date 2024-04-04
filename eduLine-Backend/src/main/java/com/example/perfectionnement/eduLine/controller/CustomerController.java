package com.example.perfectionnement.eduLine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.CourseDtoAfter;
import com.example.perfectionnement.eduLine.dto.EnrollCourse;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;
import com.example.perfectionnement.eduLine.services.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer") 
@RequiredArgsConstructor
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		List<CourseDto> courseDtoList = customerService.getAllCourses();
		return ResponseEntity.ok(courseDtoList);
	}
	
	@GetMapping("/teachers")
	public ResponseEntity<List<TeacherDto>> getAllTeachers(){
		List<TeacherDto> teacherDtoList = customerService.getAlTeachers();
		return ResponseEntity.ok(teacherDtoList);
	}
	
	@PostMapping("/course/enroll")
	public ResponseEntity<Void> enrollCourse(@RequestBody EnrollCourse enrollCourseDto){
		boolean success = customerService.enrollCourse(enrollCourseDto);
		if (success) return ResponseEntity.status(HttpStatus.CREATED).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
		CourseDto courseDto = customerService.getCourseById(courseId);
		if (courseDto==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(courseDto);
	}
	
	@GetMapping("/course/enrollments/{userId}")
	public ResponseEntity<List<EnrollCourseDto>> getEnrolledCoursesByUserId(@PathVariable Long userId) {
	    //List<CourseDto> enrolledCourses = customerService.getEnrolledCoursesByUserId(userId);
	    return ResponseEntity.ok(customerService.getEnrolledCoursesByUserId(userId));
	}


}
