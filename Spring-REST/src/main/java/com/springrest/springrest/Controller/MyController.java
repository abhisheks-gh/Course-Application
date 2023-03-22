package com.springrest.springrest.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import java.util.List;


@RestController                 // REST: Representational State Transfer
public class MyController {
    // Controller works in the Presentation layer

    // Automatically injecting the object of implementation class here
    @Autowired                              // Dependency Injection
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to courses application";    
    }

    /** Get all courses */
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    /** Get course by ID */
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    /** Add Course */ 
    // @PostMapping(path = "/courses", consumes = "application/json")  // Stating that the data will be in JSON format          
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

}
