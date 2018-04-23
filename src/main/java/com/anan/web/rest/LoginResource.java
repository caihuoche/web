package com.anan.web.rest;

import com.anan.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghaiyu
 * @date 2018/03/16
 **/
@Controller
public class LoginResource {

	public static final ThreadLocal<String> local = new ThreadLocal();

	@GetMapping("/auth")
	public String auth() {
		return "login";

	}

	@Autowired
	private UserService userService;

	@PostMapping("/login1")
	public String login(String username, String password) {
		local.set(password);
		userService.loadUserByUsername(username);
		return "789";
	}

	@GetMapping("/index")
	public String index() {
		return "index";

	}
}
