package Service;

import Model.Course;
import Repository.CourseRepository;
import Utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CourseRepository {

    @Override
    public void save(Course course, EntityManager entityManager) {
        entityManager.persist(course);

    }

    @Override
    public void update(Course course, int id, EntityManager entityManager) {
        Course foundCustomer = entityManager.find(Course.class, id);
        foundCustomer.setCourseCode(course.getCourseCode());
        foundCustomer.setCourseName(course.getCourseName());
        foundCustomer.setCreditScore(course.getCreditScore());
        entityManager.merge(foundCustomer);
    }

    @Override
    public void delete(Course course) {
    }

    @Override
    public Course findById(int id, EntityManager entityManager) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteById(int id, EntityManager entityManager) {
        Course foundCustomer = entityManager.find(Course.class, id);
        entityManager.remove(foundCustomer);
    }

    @Override
    public List<Course> findAll(EntityManager entityManager) {
        return entityManager.createQuery("from Course", Course.class).getResultList();

    }
}
