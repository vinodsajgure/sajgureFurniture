package com.sajgure.furniture.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sajgure.furniture.entity.User;
import com.sajgure.furniture.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getPage() {
		return "admin-pages/user";
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(value = "{email}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmailId(email);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveUser(@RequestBody User user) throws IOException {
		userService.save(user);
		//return "redirect:users";
	}

	@RequestMapping(value = "{email}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCarouselStatus(@PathVariable("email") String email, @RequestParam(name = "enabled") boolean status) {
		userService.updateStatus(email, status);
	}

	@RequestMapping(value = "{email}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteCarousel(@PathVariable("email") String email) {
		userService.deleteUser(email);
	}
}
