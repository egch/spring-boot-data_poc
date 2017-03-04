package org.enricogiurin.poc.springboot.form;

import javax.validation.constraints.Size;

/**
 * Created by enrico on 3/3/17.
 */
public class PersonSearchForm {

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

    private String firstName;
   private String lastName;


}
