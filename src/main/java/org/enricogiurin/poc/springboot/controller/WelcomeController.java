package org.enricogiurin.poc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by enrico on 2/17/17.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", "ciao enrico");
        return "welcome";
    }
}
