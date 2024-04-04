package com.example.perfectionnement.eduLine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.perfectionnement.eduLine.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
