package com.example.perfectionnement.eduLine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.perfectionnement.eduLine.dto.TeacherDto;

import lombok.Data;

@Entity
@Data
@Table(name = "teachers")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Teacher_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	private String fullName;
	
	@Column
	private String speciality;
	
	@Column
	private String experience;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] image;

	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public TeacherDto getTeacherDto() {
		TeacherDto teacherDto = new TeacherDto();
		teacherDto.setId(id);
		teacherDto.setFullName(fullName);
		teacherDto.setSpeciality(speciality);
		teacherDto.setExperience(experience);
		teacherDto.setReturnedImage(image);
		return teacherDto;
	}
	

}
