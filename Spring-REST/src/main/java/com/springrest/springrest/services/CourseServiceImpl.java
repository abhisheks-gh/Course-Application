package com.springrest.springrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.stream.Collectors;
// import java.util.ArrayList;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

// This class is working in the service layer
@Service                                                    
public class CourseServiceImpl implements CourseService {
    
    // Automatically injecting the object of implementation class here
    @Autowired                      // Dependency Injection
    private CourseDao courseDao;    

    // List<Course> list;

    public CourseServiceImpl() {
        // list = new ArrayList<>();
        // list.add(new Course(145, "Java Core Course", "This course contains basics of Java"));
        // list.add(new Course(4343, "Spring Boot Course", "Creating REST API using Spring Boot"));
    }

    @Override
    public List<Course> getCourses() {
        // return list;

        return courseDao.findAll();
    }

    public Course getCourse(long courseId) {
        // Course c = null;
        
        // for(Course course : list) {
        //     if (course.getId() == courseId) {
        //         c = course;
        //         break;
        //     }
        // }
        // return c;


        /** As of spring-boot v 2.7 + both getOne()
         *  and getById() are marked as deprecated and documentation says to use getReferenceById instead. */
        // return courseDao.getOne(courseId);

        return courseDao.getReferenceById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        // list.add(course);

        courseDao.save(course);

        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        // list.forEach(e -> {
        //     if (e.getId() == course.getId()) {
        //         e.setTitle(course.getTitle());
        //         e.setDescription(course.getDescription());
        //     }
        // });

        courseDao.save(course);

        return course;
    }

    public void deleteCourse(long parseLong) {
        // Extracting a stream from the list and filtering all ID's that don't match the passed ID as a list.
        // This way the passed ID will be deleted.
        // list = list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());

        // Loading entity
        Course entity = courseDao.getReferenceById(parseLong);

        // Passing entity in delete() method
        courseDao.delete(entity);
    }

}
