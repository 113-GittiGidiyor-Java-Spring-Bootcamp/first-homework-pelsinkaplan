package Controller;


import Model.Course;
import Service.CourseService;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseController {
    CourseService courseService = new CourseService();

    public void save(Course course,EntityManager em) {
        courseService.save(course, em);
    }

    public void delete(Course course) {
        courseService.delete(course);
    }

    public void deleteById(int id,EntityManager em) {
        courseService.deleteById(id, em);
    }

    public void update(Course course, int id,EntityManager em) {
        courseService.update(course, id, em);
    }

    public List<Course> findAll(EntityManager em) {
        return courseService.findAll(em);
    }

    public Course findById(int id,EntityManager em) {
        return courseService.findById(id, em);
    }

}