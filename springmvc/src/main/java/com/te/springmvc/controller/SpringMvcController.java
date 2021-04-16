package com.te.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.bean.UserBean;

@Controller
public class SpringMvcController {
	@RequestMapping(path = "/home",method =RequestMethod.GET)
	public ModelAndView gethomepage() {
		
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("home1");
	return mv;
	}
	@RequestMapping(path = "/search",method =RequestMethod.GET)
	public ModelAndView getData(ModelAndView mv,HttpServletRequest request) {
		String name=request.getParameter("name");
		//mv.addObject("Username", name);
		request.setAttribute("Username", name);
	
	mv.setViewName("home2");
	return mv;
	}
	
	@GetMapping("/login")
	public String getform() {
		return "login";
		
	}
	@PostMapping("/login")
	public String getFormData(HttpServletRequest request,ModelMap map) {
		String name=request.getParameter("user");
		int pass=Integer.parseInt(request.getParameter("pswd"));
		
		map.addAttribute("name", name);
		map.addAttribute("pswd", pass);
		
		return "userdetails";
		
	}
	@PostMapping("/login1")
	public String name(ModelMap map, int pswd,String User) {
		map.addAttribute("name", User);
		map.addAttribute("pswd", pswd);
		
		return "userdetails";
	}
	@PostMapping("/login2")
	public String getFormBean(ModelMap map,UserBean bean) {
		map.addAttribute("name",bean.getUser() );
		map.addAttribute("pswd", bean.getPswd());
		return "userdetails";
		
	
	}
	@PostMapping("/login3")
	public String getFormRequestParam(ModelMap map,@RequestParam(name ="" )String user,@RequestParam(name = "pswd")int password) {
		map.addAttribute("name",user );
		map.addAttribute("pswd", password);
		return "userdetails";
		
	}

}
