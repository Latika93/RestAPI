package com.SpringRest.ArtifactName.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.ArtifactName.Entity.Courses;
import com.SpringRest.ArtifactName.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService ;

	@GetMapping("/home")
	public String home() {
		return "This is home message";
	}
	
	//get th courses
	@GetMapping("/Courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/Courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	
	@PostMapping("/Courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
		
	}
	
	@PutMapping("/Courses")
	public Courses updateService(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/Courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
