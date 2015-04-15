package com.sejian.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sejian.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User add(@PathVariable(value = "id") String id) {
		User user = new User();
		user.setId(id);
		user.setUserName("Alex");
		return user;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public String register(String id, String userName, String password) {

		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User get(@PathVariable String id) {
		User user = new User();
		user.setId(id);
		user.setUserName("Alex");
		return user;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list() {
		return null;
	}

	@RequestMapping(value = "")
	public String resetPassword() {

		return null;
	}

	public String recover() {

		return null;
	}

	public String freeze() {
		return null;
	}

	public String search() {

		return null;
	}
}
