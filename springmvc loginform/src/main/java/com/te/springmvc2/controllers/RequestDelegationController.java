package com.te.springmvc2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDelegationController {

	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:https://google.com";
	}
	
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:/login";
	}
	
}
