package com.te.springmvc2.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	
	@GetMapping("/cookiepage")
	public String getCookiePage() {
		
		return "cookiepage";
	}
	
	@GetMapping("/createcookie")
	public String cookie(HttpServletResponse response,ModelMap map) {
		Cookie cookie = new Cookie("empname", "dil");
		response.addCookie(cookie);
		map.addAttribute("msg", "added cookies");
		return "cookiepage";
	}
	
	@GetMapping("/showcookie")
	public String showCookies(@CookieValue(name = "empname",required = false)String name,ModelMap map){
		map.addAttribute("cookie", name);
		return "cookiepage";
	}

}
