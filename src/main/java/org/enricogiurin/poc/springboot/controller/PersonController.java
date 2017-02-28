package org.enricogiurin.poc.springboot.controller;

import org.enricogiurin.poc.springboot.model.Person;
import org.enricogiurin.poc.springboot.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by enrico on 2/27/17.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // @ResponseBody
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public String getAll(Model model) {
        System.out.println("entered in the controller "+getClass().getSimpleName());
        //List<Person> people = personDao.getAll();
        //Iterable<Person> people = personRepository.findAll();
        Iterable<Person> people = personRepository.findByPartialFirstName("%enr%");
        model.addAttribute("people", people);
        return "listPeople";
    }

}
