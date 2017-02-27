package org.enricogiurin.poc.springboot.controller;

import org.enricogiurin.poc.springboot.model.Person;
import org.enricogiurin.poc.springboot.model.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by enrico on 2/27/17.
 */
@Controller
public class PersonController {
    @Autowired
    private PersonDao personDao;


    @RequestMapping(value="/people")
    @ResponseBody
    public List<Person> getAll() {
        System.out.println("entered in the controller "+getClass().getSimpleName());
        return personDao.getAll();
    }

}
