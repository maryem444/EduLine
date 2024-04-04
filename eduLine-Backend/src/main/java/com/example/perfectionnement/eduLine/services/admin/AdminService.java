package com.example.perfectionnement.eduLine.services.admin;

import java.io.IOException;
import java.util.List;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;


public interface AdminService {

	//TEACHER_CRUD
	boolean addTeacher(TeacherDto teacherDto) throws IOException;
	
	List<TeacherDto> getAllTeachers();
	
	void deleteTeacher(Long id);
	
	TeacherDto getTeacherById(Long id);
	
	boolean updateTeacher(Long teacherId, TeacherDto teacherDto) throws IOException;

	
	//COURSE_CRUD
	boolean addCourse(CourseDto courseDto) throws IOException;
	
	List<CourseDto> getAllCourses();
	
	void deleteCourse(Long id);
	
	CourseDto getCourseById(Long id);
	
	boolean updateCourse(Long courseId, CourseDto courseDto) throws IOException;
	
	List<EnrollCourseDto> getEnrollments();
	
	boolean changeEnrollmentStatus(Long enrollmentId, String status);
}
