package org.enricogiurin.poc.springboot.controller.json;

import org.enricogiurin.poc.springboot.model.Person;
import org.enricogiurin.poc.springboot.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by enrico on 2/27/17.
 */
@Controller(value = "jsonPersonController")
@RequestMapping("/json/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /*@RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
*/

    @GetMapping("/{personId}")
    public @ResponseBody Person findOne(@PathVariable Long personId) {
            return personRepository.findOne(personId);
        }




}
