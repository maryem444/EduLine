package com.example.perfectionnement.eduLine.services.customer;

import java.util.List;



import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.CourseDtoAfter;
import com.example.perfectionnement.eduLine.dto.EnrollCourse;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;

public interface CustomerService {
	
	List<CourseDto> getAllCourses();

	List<TeacherDto> getAlTeachers();
	
	boolean enrollCourse(EnrollCourse enrollCourseDto);
	
	CourseDto getCourseById(Long courseId);

	List<EnrollCourseDto> getEnrolledCoursesByUserId(Long userId);
}
