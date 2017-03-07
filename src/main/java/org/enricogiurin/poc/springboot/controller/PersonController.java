package org.enricogiurin.poc.springboot.controller;

import org.enricogiurin.poc.springboot.form.PersonForm;
import org.enricogiurin.poc.springboot.form.PersonSearchForm;
import org.enricogiurin.poc.springboot.model.Person;
import org.enricogiurin.poc.springboot.model.PersonRepository;
import org.enricogiurin.poc.springboot.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by enrico on 2/27/17.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/search")
    public String searchView(@ModelAttribute("form") @Valid PersonSearchForm form, BindingResult result, Model model) {
        Person person = personRepository.findByFirstNameAndLastName(form.getFirstName(), form.getLastName());
        model.addAttribute("person", person);
        return "jsp/person/personSummary";
    }

    @GetMapping(value = "/search")
    public String search(@ModelAttribute("form") @Valid PersonSearchForm form, BindingResult result) {
        return "jsp/person/searchPerson";
    }


    @GetMapping("/{personId}")
    public String getPerson(@PathVariable Long personId, Model model) {
        Person person = personRepository.findOne(personId);
        model.addAttribute("person", person);
        return "jsp/person/personSummary";
    }

    @GetMapping(value = "")
    public String getAll(Model model) {
        Iterable<Person> people = personRepository.findAll();
        model.addAttribute("people", people);
       // return "jsp/person/listPerson";
        return "listPerson";
    }

    @GetMapping("/{personId}/edit")
    public String editPersonView(@PathVariable Long personId,
                                 @ModelAttribute("form") @Valid PersonForm form,
                                 BindingResult result) {
        Person person = null;
        if (personId != null) {
            person = personRepository.findOne(personId);
            form.setId(String.valueOf(person.getId()));
        }else {
            person = new Person();
        }
        form.setLastName(person.getLastName());
        form.setFirstName(person.getFirstName());

        return "jsp/person/editPerson";
    }

    @GetMapping("/new")
    public String newPersonView(@ModelAttribute("form") @Valid PersonForm form,
                                 BindingResult result) {
        return "jsp/person/createPerson";
    }




    @PostMapping(value = "/{personId}")
    public String editPerson(@PathVariable Long personId,
                             @ModelAttribute("form") @Valid PersonForm form,
                             BindingResult result) {
        Person person = null;
        if (personId != null) {
            person = personRepository.findOne(personId);
            if (person == null) {
                throw new IllegalArgumentException("no Person found with id " + personId);
            }
        } else {
            person = new Person();
        }
        person.setBirthdate(Converter.stringToLocalDate(form.getBirthdate()));
        person.setFirstName(form.getFirstName());
        person.setLastName(form.getLastName());
        personRepository.save(person);
        return "redirect:/person";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("form") @Valid PersonForm form,
                               BindingResult result) {
        return editPerson(null, form, result);
    }

    //I need to find a way to use the proper @DeleteMapping
    @GetMapping(value = "/{personId}/delete")
    public String deleteUser(@PathVariable Long personId) {

        Person person = null;
        person = personRepository.findOne(personId);
        personRepository.delete(person);
        return "redirect:/person";
    }

}
