package Service;

import Model.Student;
import Repository.StudentRepository;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements StudentRepository {


    @Override
    public void save(Student student, EntityManager entityManager) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student, int id, EntityManager entityManager) {
            Student foundStudent = entityManager.find(Student.class, id);
            foundStudent.setAddress(student.getAddress());
            foundStudent.setBirthDate(student.getBirthDate());
            foundStudent.setGender(student.getGender());
            foundStudent.setName(student.getName());
            entityManager.merge(foundStudent);
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public Student findById(int id, EntityManager entityManager) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteById(int id, EntityManager entityManager) {
            Student foundStudent = entityManager.find(Student.class, id);
            entityManager.remove(foundStudent);
    }

    @Override
    public List<Student> findAll(EntityManager entityManager) {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
