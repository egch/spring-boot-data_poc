package org.enricogiurin.poc.springboot.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by enrico on 2/28/17.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByFirstName(String firstName);
    List<Person> findByPartialFirstName(String partialFirstName);
}
