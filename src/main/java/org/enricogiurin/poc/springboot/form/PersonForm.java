package org.enricogiurin.poc.springboot.form;

import javax.validation.constraints.Size;

/**
 * Created by enrico on 3/3/17.
 */
public class PersonForm {

    @Size(max = 64)
    private String id;

    private String firstName;
    private String lastName;
    private String birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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