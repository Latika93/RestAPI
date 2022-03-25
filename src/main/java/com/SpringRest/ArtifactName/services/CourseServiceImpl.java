package com.SpringRest.ArtifactName.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringRest.ArtifactName.Entity.Courses;

@Service
public class CourseServiceImpl implements CourseService{

	List <Courses> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses(14, "Java Core" ,"Learn core java here"));
		list.add(new Courses(15, "Java advance" ,"Learn Advance java here"));
		list.add(new Courses(16, "Java servelts" ,"Learn servlets java here"));
	}
	
	@Override
	public List<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		Courses c = null;
		
		for(Courses course: list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {

		list.forEach(e -> {
			if(e.getId()== course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
//		list = this.list.stream().filter(e->e.getId()!= parseLong).collect(Collectors.toList());
	}

}
