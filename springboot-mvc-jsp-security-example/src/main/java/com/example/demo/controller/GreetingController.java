package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Greeting;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(Model model)
	{
	     model.addAttribute("greeting", new Greeting());
	       return "greeting";
	}
    
    @PostMapping("/greeting")
    public String postGreeting(@ModelAttribute("greeting") Greeting greeting, ModelMap model)
    {
    	model.addAttribute("name", greeting.getContent());
    
        return "resultGreeting";
    }

}
