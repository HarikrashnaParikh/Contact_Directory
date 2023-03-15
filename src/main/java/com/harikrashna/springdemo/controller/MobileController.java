package com.harikrashna.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harikrashna.springdemo.entity.Mobile;
import com.harikrashna.springdemo.entity.User;
import com.harikrashna.springdemo.service.MobileService;
import com.harikrashna.springdemo.service.UserService;

@Controller
@RequestMapping("/mobile")
public class MobileController {
	

	//need to inject the User service
	@Autowired
	private MobileService mobileService;
	
	@GetMapping("/list")
	public String listusers(Model theModel) {
		
		//get users from the User service
		List<Mobile> theMobiles = mobileService.getMobiles();
		
		
		//add the users to the model
		theModel.addAttribute("mobiles",theMobiles);
		
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create model attribute to bind form data
		Mobile theMobile = new Mobile();
		
		theModel.addAttribute("mobile",theMobile);
		
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveMobile(@ModelAttribute("mobile") Mobile theMobile) {
		//save the user using our device
		mobileService.saveMobile(theMobile);
		
		return "redirect:/user/list";
		
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("mobileId") int theId,Model theModel) {
		
		
		//get the user from service
		Mobile theMobile = mobileService.getMobile(theId);
		System.out.println(theMobile+"======="+theId);
		//set user as a model attribute to pre-populate the form 
		theModel.addAttribute("mobile", theMobile);
		//send over to our form 
		return "user-form";
	
	}
	
	@GetMapping("/delete")
	public String deleteMobile(@RequestParam("mobileId") int theId) {
		//delete the customer
		mobileService.deleteMobile(theId);
		
		
		
		return "redirect:/user/list";
	}

}
