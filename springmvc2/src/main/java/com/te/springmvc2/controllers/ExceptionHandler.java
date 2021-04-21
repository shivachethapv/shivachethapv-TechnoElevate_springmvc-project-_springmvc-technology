package com.te.springmvc2.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import com.te.springmvc2.customexception.EmployeeExp;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(EmployeeExp.class)
	public String handler(EmployeeExp exp,HttpServletRequest request) {
		request.setAttribute("err", exp.getMessage());
		return "errorpage";
	}
}
