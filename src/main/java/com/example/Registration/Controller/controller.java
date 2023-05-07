package com.example.Registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Registration.Services.userservice;
import com.example.Registration.entities.userforregistration;

@Controller
public class controller {

	@Autowired
	userservice service;
	
	
	//very first page when we call the application on local host on port define in application.properties file
	// this is our custom login page by default set in security config 

	@GetMapping("/log")

	public String login() {
		return "Newlogin";
	}

	
	//for getting register fire this url
	@GetMapping("/register")
	public String registertheuser(Model model) {

		userforregistration user1 = new userforregistration();

		model.addAttribute("user", user1);

		return "Newreg";
	}

	 //custom login handler method
	@GetMapping("/ki")
	public void  ji() {
		
		
	}
	
	
	// after successful login 
	@GetMapping("/hi")
	public String home() {
		return "index";
	}
	
	
	// this url will work when register successfully

	@PostMapping("/h")

	public String userregistered(@ModelAttribute("user") userforregistration user) {

		service.saveuser(user);
		return "redirect:/register?success";

	}

}
