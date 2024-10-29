package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.dto.UserRequestDTO;
import com.recipe.dto.UserResponseDTO;
import com.recipe.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {
		return userService.createUser(request);
	}
	
	@GetMapping
	public List<UserResponseDTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "user is deleted successfully with id :"+id;
	}
}
