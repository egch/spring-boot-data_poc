package org.enricogiurin.poc.springboot.controller;

import org.enricogiurin.poc.springboot.form.PersonCreateForm;
import org.enricogiurin.poc.springboot.model.Person;
import org.enricogiurin.poc.springboot.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by enrico on 2/27/17.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // @ResponseBody
    @RequestMapping(value = "/people.html", method = RequestMethod.GET)
    public String getAll(Model model) {
        System.out.println("entered in the controller "+getClass().getSimpleName());
        //Iterable<Person> people = personRepository.findByPartialFirstName("%enr%");
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
        return "listPeople";
    }


    @RequestMapping(value = "/person_create.html", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("form") @Valid PersonCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "createPerson";
        }
        Person person = new Person();
        person.setFirstName(form.getFirstName());
        person.setLastName(form.getLastName());
        personRepository.save(person);

        return "redirect:/people.html";
    }

    @RequestMapping(value = "/person_create.html", method = RequestMethod.GET)
    public String createUserView(@ModelAttribute("form") @Valid PersonCreateForm form, BindingResult result) {
        return "createPerson";
    }


}
