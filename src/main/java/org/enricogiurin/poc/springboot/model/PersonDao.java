package org.enricogiurin.poc.springboot.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by enrico on 2/27/17.
 */
@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Person> getAll() {
        return entityManager.createQuery("from Person").getResultList();
    }

}
