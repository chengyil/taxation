package com.pajak.taxation.controllers;

import com.pajak.taxation.models.Entity;
import com.pajak.taxation.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private AssessmentService assessmentService;

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
        model.addAttribute("result", assessmentService.perform(entity));
        return "index";
    }
}
