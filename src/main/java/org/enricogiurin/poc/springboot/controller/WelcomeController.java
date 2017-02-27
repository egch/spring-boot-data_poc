package org.enricogiurin.poc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by enrico on 2/17/17.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/aa")
    public String welcome(Map<String, Object> model) {
        System.out.println("I am here");
        model.put("message", "ciao enrico");
        System.out.println("inserted");
        return "welcome";
    }
}
