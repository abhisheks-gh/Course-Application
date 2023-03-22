package com.springrest.springrest.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.springrest.springrest.entities.Course;


@Service        // This class is working in the service layer
public class CourseServiceImpl implements CourseService {
    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(145, "Java Core Course", "This course contains basics of Java"));
        list.add(new Course(4343, "Spring Boot Course", "Creating REST API using Spring Boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    public Course getCourse(long courseId) {
        Course c = null;
        
        for(Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });

        return course;
    }

    public void deleteCourse(long parseLong) {
        // Extracting a stream from the list and filtering all ID's that don't match the passed ID as a list.
        // This way the passed ID will be deleted.
        list = list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
    }

}
