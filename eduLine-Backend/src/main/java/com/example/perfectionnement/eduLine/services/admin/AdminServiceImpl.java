package com.example.perfectionnement.eduLine.services.admin;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.perfectionnement.eduLine.dto.CourseDto;
import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.dto.TeacherDto;
import com.example.perfectionnement.eduLine.entity.Course;
import com.example.perfectionnement.eduLine.entity.EnrollCourse;
import com.example.perfectionnement.eduLine.entity.Teacher;
import com.example.perfectionnement.eduLine.enums.EnrollCourseStatus;
import com.example.perfectionnement.eduLine.repository.CourseRepository;
import com.example.perfectionnement.eduLine.repository.EnrollCourseRepository;
import com.example.perfectionnement.eduLine.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EnrollCourseRepository enrollCourseRepository;
	
	//Teacher
	@Override
	public boolean addTeacher(TeacherDto teacherDto) throws IOException {
		System.out.println("dkhal");
		
		try {
			MultipartFile image = teacherDto.getImage();

	        if (image == null) {
	        	System.out.println("Image not found");
	            // Handle the case when the image is null (e.g., log a warning, provide a default image)
	            // For now, let's just return false as an example
	            return false;
	        }
	        System.out.println("Image found");
			Teacher teacher = new Teacher();
			teacher.setFullName(teacherDto.getFullName());
			teacher.setSpeciality(teacherDto.getSpeciality());
			teacher.setExperience(teacherDto.getExperience());
			System.out.println(teacherDto.getImage().getBytes());
			teacher.setImage(teacherDto.getImage().getBytes());
			teacherRepository.save(teacher);
			return true;
		} catch (Exception e) {
            e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<TeacherDto> getAllTeachers() {
		return teacherRepository.findAll().stream().map(Teacher::getTeacherDto).collect(Collectors.toList());
	}

	@Override
	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}

	@Override
	public TeacherDto getTeacherById(Long id) {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
		return optionalTeacher.map(Teacher::getTeacherDto).orElse(null);

	}

	@Override
	public boolean updateTeacher(Long teacherId, TeacherDto teacherDto) throws IOException {
		Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
		if(optionalTeacher.isPresent()) {
			Teacher existingTeacher = optionalTeacher.get();
			if(teacherDto.getImage() != null) 
				existingTeacher.setImage(teacherDto.getImage().getBytes());
			existingTeacher.setFullName(teacherDto.getFullName());
			existingTeacher.setExperience(teacherDto.getExperience());
			existingTeacher.setSpeciality(teacherDto.getSpeciality());
			teacherRepository.save(existingTeacher);
			return true;
		}else {
		return false;
		}
	}

	/**********************************************************/
	
	//Course
	@Override
	public boolean addCourse(CourseDto courseDto) throws IOException {
	    System.out.println("Received Course DTO: " + courseDto);

	    try {
	        Course course = new Course();
	        course.setCourseTitle(courseDto.getCourseTitle());
	        course.setCoursePrice(courseDto.getCoursePrice());
	        course.setStartDate(courseDto.getStartDate());
	        course.setDuration(courseDto.getDuration());
	        courseRepository.save(course);
	        System.out.println("Course saved successfully");
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	@Override
	public List<CourseDto> getAllCourses() {
		return courseRepository.findAll().stream().map(Course::getCourseDto).collect(Collectors.toList());
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
		
	}

	@Override
	public CourseDto getCourseById(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		return optionalCourse.map(Course::getCourseDto).orElse(null);
	}

	@Override
	public boolean updateCourse(Long courseId, CourseDto courseDto) {
	    Optional<Course> optionalCourse = courseRepository.findById(courseId);
	    if (optionalCourse.isPresent()) {
	        Course existingCourse = optionalCourse.get();

	        // Update the fields that can be modified
	        existingCourse.setCourseTitle(courseDto.getCourseTitle());
	        existingCourse.setCoursePrice(courseDto.getCoursePrice());
	        existingCourse.setStartDate(courseDto.getStartDate());
	        existingCourse.setDuration(courseDto.getDuration());

	        courseRepository.save(existingCourse);
	        return true;
	    } else {
	        return false;
	    }
	}

	/**********************************************************/
	
	//Enrollments
	@Override
	public List<EnrollCourseDto> getEnrollments() {
		return enrollCourseRepository.findAll().stream().map(EnrollCourse::getEnrollCourseDto).collect(Collectors.toList());
	}

	@Override
	public boolean changeEnrollmentStatus(Long enrollmentId, String status) {
		Optional<EnrollCourse> optionalEnrollCourse = enrollCourseRepository.findById(enrollmentId);
		if (optionalEnrollCourse.isPresent()) {
			EnrollCourse existingEnrollCourse = optionalEnrollCourse.get();
			if(Objects.equals(status, "Approve"))
				existingEnrollCourse.setEnrollCourseStatus(EnrollCourseStatus.APPROVED);
			else
				existingEnrollCourse.setEnrollCourseStatus(EnrollCourseStatus.REJECTED);
			enrollCourseRepository.save(existingEnrollCourse);
			return true;
		}
		return false;
	}

	
	
}
