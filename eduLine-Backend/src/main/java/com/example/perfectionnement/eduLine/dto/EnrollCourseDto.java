package com.example.perfectionnement.eduLine.dto;

import java.sql.Timestamp;

import com.example.perfectionnement.eduLine.entity.Course;
import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EnrollCourseDto {

	private Long id;
    private String firstName;
    private String lastName;
    private Long courseId;
    private Long userId;

    private String courseTitle;
    private float coursePrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd", timezone = "GMT")
	private Timestamp startDate;

	private int duration;
	
	private User user;
	
	private Course course;


	private String email;

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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public float getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(float coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
