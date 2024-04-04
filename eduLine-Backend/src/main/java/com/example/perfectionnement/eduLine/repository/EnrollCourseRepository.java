package com.example.perfectionnement.eduLine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.perfectionnement.eduLine.dto.EnrollCourseDto;
import com.example.perfectionnement.eduLine.entity.EnrollCourse;

@Repository
public interface EnrollCourseRepository extends JpaRepository<EnrollCourse, Long>{
	@Query("SELECT e FROM EnrollCourse e JOIN FETCH e.user JOIN FETCH e.course WHERE e.user.id = :userId")
	List<EnrollCourse> findAllByUser_Id(Long userId);

}
