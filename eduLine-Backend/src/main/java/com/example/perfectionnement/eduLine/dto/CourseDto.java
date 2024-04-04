package com.example.perfectionnement.eduLine.dto;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;

@Data
public class CourseDto {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String courseTitle;
	
	private float coursePrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd", timezone = "GMT")
	private Timestamp startDate;

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

	

}
