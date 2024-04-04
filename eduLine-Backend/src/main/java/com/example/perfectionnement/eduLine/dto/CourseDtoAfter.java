package com.example.perfectionnement.eduLine.dto;

import java.sql.Timestamp;
import java.util.List;

import com.example.perfectionnement.eduLine.entity.Course;
import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CourseDtoAfter {
	
	    private Long id;
	    private List<CourseDto> courses;
	    public List<CourseDto> getCourses() {
			return courses;
		}
		public void setCourses(List<CourseDto> courses) {
			this.courses = courses;
		}
		private EnrollCourseStatus enrollCourseStatus; // Add course status field
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		public EnrollCourseStatus getEnrollCourseStatus() {
			return enrollCourseStatus;
		}
		public void setEnrollCourseStatus(EnrollCourseStatus enrollCourseStatus) {
			this.enrollCourseStatus = enrollCourseStatus;
		}



}
