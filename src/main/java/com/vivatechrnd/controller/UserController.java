package com.vivatechrnd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vivatechrnd.model.User;
import com.vivatechrnd.repository.UserRepository;
import com.vivatechrnd.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@PostMapping("/user")
	public String createNewUser(@RequestBody User user) {
		System.out.print("sdf");
		userRepository.save(user);
		return "new user created";
	}
	@GetMapping("/user")
	public ResponseEntity<List<User>>getAllUser() {
		List<User>uList=new ArrayList<>();
		userRepository.findAll().forEach(uList::add);
		return new ResponseEntity<List<User>>(uList,HttpStatus.OK);
	}
	@GetMapping("/otpVerification")
	public String otpSent() {
		return "otpScreen";
	}
	@PutMapping("/verify-otp")
	  public ResponseEntity<String> verifyAccount(@RequestParam String email,
	      @RequestParam String otp) {
	    return new ResponseEntity<>(UserService.verifyOtp(email, otp), HttpStatus.OK);
	  }
}
