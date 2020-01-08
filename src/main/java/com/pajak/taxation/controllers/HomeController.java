package com.pajak.taxation.controllers;

import com.pajak.taxation.models.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @ModelAttribute("allMaritalStatus")
    public List<Entity.MaritalStatus> allMaritalStatus(){
        return Arrays.asList(Entity.MaritalStatus.values());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("entity", new Entity());
        return "index";
    }

    @RequestMapping(value = "/assessment", method = RequestMethod.POST)
    public String assessment(Model model, @ModelAttribute Entity entity) {
        model.addAttribute("result", entity);
        return "index";
    }
}
