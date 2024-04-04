package com.example.perfectionnement.eduLine.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;

import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Course_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	private String courseTitle;
	
	@Column
	private float coursePrice;
	
	@Column
	private Timestamp startDate;
	
	@Column
	private int duration;
	
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

	public CourseDto getCourseDto() {
		CourseDto courseDto = new CourseDto();
		courseDto.setId(id);
		courseDto.setCourseTitle(courseTitle);
		courseDto.setCoursePrice(coursePrice);
		courseDto.setStartDate(startDate);
		courseDto.setDuration(duration);
		return courseDto;
	}
	
	


}
