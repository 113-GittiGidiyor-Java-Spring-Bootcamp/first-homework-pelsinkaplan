package Service;

import Model.Instructor;
import Model.Student;
import Repository.InstructorRepository;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements InstructorRepository {

    @Override
    public void save(Instructor instructor,EntityManager entityManager) {
        entityManager.persist(instructor);

    }

    @Override
    public void update(Instructor instructor, int id,EntityManager entityManager) {
            Instructor foundInstructor = entityManager.find(Instructor.class, id);
            foundInstructor.setAddress(instructor.getAddress());
            foundInstructor.setName(instructor.getName());
            foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
            entityManager.merge(foundInstructor);
    }

    @Override
    public void delete(Instructor instructor) {

    }

    @Override
    public Instructor findById(int id,EntityManager entityManager) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void deleteById(int id,EntityManager entityManager) {
            Instructor foundInstructor = entityManager.find(Instructor.class, id);
            entityManager.remove(foundInstructor);
    }

    @Override
    public List<Instructor> findAll(EntityManager entityManager) {
        return entityManager.createQuery("from Instructor", Instructor.class).getResultList();
    }
}
