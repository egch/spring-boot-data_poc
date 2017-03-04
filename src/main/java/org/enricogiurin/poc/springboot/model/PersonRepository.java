package org.enricogiurin.poc.springboot.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by enrico on 2/28/17.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByFirstNameAndLastName(String firstName, String lastName);
    List<Person> findByPartialFirstName(String partialFirstName);
}
