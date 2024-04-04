package com.example.perfectionnement.eduLine.services.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.CourseDtoAfter;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;
import com.example.perfectionnement.eduLine.entity.Course;
import com.example.perfectionnement.eduLine.entity.EnrollCourse;
import com.example.perfectionnement.eduLine.entity.Teacher;
import com.example.perfectionnement.eduLine.entity.User;
import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;
import com.example.perfectionnement.eduLine.repository.CourseRepository;
import com.example.perfectionnement.eduLine.repository.EnrollCourseRepository;
import com.example.perfectionnement.eduLine.repository.TeacherRepository;
import com.example.perfectionnement.eduLine.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EnrollCourseRepository enrollCourseRepository;
	
	@Override
	public List<CourseDto> getAllCourses() {
		return courseRepository.findAll().stream().map(Course::getCourseDto).collect(Collectors.toList());
	}

	@Override
	public List<TeacherDto> getAlTeachers() {
		return teacherRepository.findAll().stream().map(Teacher::getTeacherDto).collect(Collectors.toList());
	}

	@Override
	public boolean enrollCourse(com.example.perfectionnement.eduLine.dto.EnrollCourse enrollCourseDto) {
		Optional<Course> optionalCourse = courseRepository.findById(enrollCourseDto.getCourseId());
		Optional<User> optionalUser = userRepository.findById(enrollCourseDto.getUserId());
		if (optionalCourse.isPresent() && optionalUser.isPresent()) {
			Course existingCourse = optionalCourse.get() ;
			EnrollCourse enrollCourse = new EnrollCourse();
			enrollCourse.setCourse(existingCourse);
			enrollCourse.setUser(optionalUser.get());
			enrollCourse.setEnrollCourseStatus(EnrollCourseStatus.PENDING); 
			enrollCourseRepository.save(enrollCourse);
			return true;
		}
		return false;
	}

	@Override
	public CourseDto getCourseById(Long courseId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		return optionalCourse.map(Course::getCourseDto).orElse(null);
		
	}

	@Override
	public List<EnrollCourseDto> getEnrolledCoursesByUserId(Long userId) {
	    return enrollCourseRepository.findAllByUser_Id(userId).stream().map(EnrollCourse::getEnrollCourseDto).collect(Collectors.toList());
	}
	
}
