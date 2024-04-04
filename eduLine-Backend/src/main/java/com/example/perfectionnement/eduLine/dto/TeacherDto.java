package com.example.perfectionnement.eduLine.dto;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TeacherDto {

	private Long id;

	private String fullName;
	
	private String speciality;
	
	private String experience;
	
	private MultipartFile image;
	
	private byte[] returnedImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public byte[] getReturnedImage() {
		return returnedImage;
	}

	public void setReturnedImage(byte[] returnedImage) {
		this.returnedImage = returnedImage;
	}

	
	

	
}
