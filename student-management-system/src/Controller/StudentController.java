package Controller;

import Model.Student;
import Service.StudentService;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentController {
    StudentService studentService = new StudentService();

    public void save(Student student,EntityManager em){
        studentService.save(student,em);
    }

    public List<Student> findAll(EntityManager em){
        return studentService.findAll(em);
    }

    public void delete(Student student){
        studentService.delete(student);
    }

    public void deleteById(int id,EntityManager em){
        studentService.deleteById(id,em);
    }

    public Student findById(int id,EntityManager em){
        return studentService.findById(id,em);
    }

    public void update(Student student, int id,EntityManager em){
        studentService.update(student,id,em);
    }}
