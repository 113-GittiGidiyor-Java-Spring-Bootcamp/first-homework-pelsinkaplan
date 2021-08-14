package Clients;

import Controller.CourseController;
import Controller.InstructorController;
import Controller.StudentController;
import Model.*;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        Test();
    }

    public static void Test() {


        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        InstructorController instructorController = new InstructorController();

        Instructor instructor = new PermanentInstructor("Ayse", "Istabul", "05555555555", 5000);
        Instructor instructor2 = new PermanentInstructor("Fatma", "Istabul", "05444444444", 6000);
        Instructor instructor3 = new VisitingResearcher("Hayriye", "Istabul", "05333333333", 7000);

        Course course = new Course("Calculus 1", "MATH101", 5, instructor);
        Course course2 = new Course("Computer Programming 1", "CSE101", 6, instructor2);
        Course course3 = new Course("Artificial Intelligence", "AI", 8, instructor3);

        Student student = new Student("Pelsin KAPLAN", LocalDate.of(1998, 1, 20), "Istanbul", "Female");
        Student student2 = new Student("Can KAPLAN", LocalDate.of(1996, 7, 10), "Istanbul", "Male");
        Student student3 = new Student("Berat KAPLAN", LocalDate.of(2012, 3, 9), "Istanbul", "Male");
        Student student4 = new Student("Zeynep KAPLAN", LocalDate.of(2015, 6, 23), "Istanbul", "Female");

        List<Course> courses = new ArrayList<>();
        List<Course> courses2 = new ArrayList<>();
        List<Course> courses3 = new ArrayList<>();
        courses.add(course);
        courses.add(course2);
        courses2.add(course);
        courses2.add(course2);
        courses2.add(course3);
        courses3.add(course3);

        student.setCourses(courses);
        student.setCourses(courses2);
        student.setCourses(courses3);

        instructor.setCourses(courses);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            studentController.save(student,em);
            studentController.save(student2,em);
            studentController.save(student3,em);
            studentController.save(student4,em);

            instructorController.save(instructor,em);
            instructorController.save(instructor2,em);
            instructorController.save(instructor3,em);

            courseController.save(course,em);
            courseController.save(course2,em);
            courseController.save(course3,em);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

        System.out.println("Success..");
    }
}
