package com.example.perfectionnement.eduLine.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "enrollments")
public class EnrollCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "User_ID",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "Course_ID",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	@JsonIgnore
	private Course course;

	private EnrollCourseStatus enrollCourseStatus;
	
	public EnrollCourseDto getEnrollCourseDto() {
		EnrollCourseDto enrollCourseDto = new EnrollCourseDto();
		enrollCourseDto.setId(id);
		enrollCourseDto.setCourseTitle(course.getCourseTitle());
		enrollCourseDto.setCoursePrice(course.getCoursePrice());
		enrollCourseDto.setDuration(course.getDuration());
		enrollCourseDto.setStartDate(course.getStartDate());
		enrollCourseDto.setEnrollCourseStatus(enrollCourseStatus);
		enrollCourseDto.setEmail(user.getEmail());
		enrollCourseDto.setFirstName(user.getFirstName());
		enrollCourseDto.setLastName(user.getLastName());
		enrollCourseDto.setCourseId(course.getId());
		enrollCourseDto.setUserId(user.getId());
		return enrollCourseDto;
	}
	
	
	
	

	public EnrollCourseStatus getEnrollCourseStatus() {
		return enrollCourseStatus;
	}

	public void setEnrollCourseStatus(EnrollCourseStatus enrollCourseStatus) {
		this.enrollCourseStatus = enrollCourseStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
