package com.SpringRest.ArtifactName.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.SpringRest.ArtifactName.Entity.Courses;

public interface CourseService {
	public List <Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public void deleteCourse(long courseId);
}
