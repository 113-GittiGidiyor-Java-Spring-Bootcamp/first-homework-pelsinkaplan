package Repository;

import javax.persistence.EntityManager;
import java.util.List;

public interface CrudRepository<T> {
    void save(T t, EntityManager e);

    void update(T t, int id,EntityManager entityManager);

    void delete(T t);

    T findById(int id,EntityManager entityManager);

    void deleteById(int id,EntityManager entityManager);

    List<T> findAll(EntityManager entityManager);


}
