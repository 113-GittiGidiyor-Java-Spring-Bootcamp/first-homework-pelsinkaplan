package Controller;

import Model.Instructor;
import Service.InstructorService;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorController {
    InstructorService instructorService = new InstructorService();

    public void save(Instructor instructor,EntityManager em) {
        instructorService.save(instructor,em);
    }

    public void delete(Instructor instructor) {
        instructorService.delete(instructor);
    }

    public void delete(int id,EntityManager em) {
        instructorService.deleteById(id,em);
    }

    public List<Instructor> findAll(EntityManager em) {
        return instructorService.findAll(em);
    }

    public Instructor findById(int id,EntityManager em) {
        return instructorService.findById(id,em);
    }

    public void update(Instructor instructor, int id,EntityManager em) {
        instructorService.update(instructor, id,em);
    }
}
