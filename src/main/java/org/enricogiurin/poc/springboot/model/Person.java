package org.enricogiurin.poc.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by enrico on 2/27/17.
 */
@Entity
@Table(name = "person")
@NamedQueries(value = {@NamedQuery(name = "Person.findByPartialFirstName", query =
        "from Person p where upper(p.firstName) like upper(?) order by p.firstName asc")})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
