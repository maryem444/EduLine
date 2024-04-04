package com.example.perfectionnement.eduLine.dto;

import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;

public class EnrollCourse {

	private Long id;
	
	private Long courseId;
	
	private Long userId;
	

	public Long getId() {
		return id;
	}

	private EnrollCourseStatus enrollCourseStatus;
	
	
	public EnrollCourseStatus getEnrollCourseStatus() {
		return enrollCourseStatus;
	}

	public void setEnrollCourseStatus(EnrollCourseStatus enrollCourseStatus) {
		this.enrollCourseStatus = enrollCourseStatus;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
}
