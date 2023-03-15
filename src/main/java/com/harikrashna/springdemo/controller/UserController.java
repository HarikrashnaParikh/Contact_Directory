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

//import com.harikrashna.springdemo.dao.UserDAO;
import com.harikrashna.springdemo.entity.User;
import com.harikrashna.springdemo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//need to inject the User service
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listusers(Model theModel) {
		
		System.out.println("Hii I am here");
		//get users from the User service
		List<User> theUsers = userService.getUsers();
		
		for(User user:theUsers) {
			System.out.println(user.getMobiles());
			
		}
		//add the users to the model
		theModel.addAttribute("users",theUsers);
		
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		//create model attribute to bind form data
		User theUser = new User();
		theModel.addAttribute("user",theUser);
		
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		//save the user using our device
		userService.saveUser(theUser);
		
		return "redirect:/user/list";
		
		
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId,Model theModel) {
		
		
		//get the user from service
		User theUser = userService.getUser(theId);
		//set user as a model attribute to pre-populate the form 
		theModel.addAttribute("user", theUser);
		//send over to our form 
		return "user-form";
	
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		//delete the customer
		userService.deleteUser(theId);
		
		
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/search")
	public String searchUsers(@RequestParam("theSearchName") String theSearchName,Model theModel)
	{
		//search users from the device
		List<User> theUsers = userService.searchUsers(theSearchName);
		
		//add the Users to the model
		theModel.addAttribute("users",theUsers);
		return "list-users";
	}
	
	
	
	
}
