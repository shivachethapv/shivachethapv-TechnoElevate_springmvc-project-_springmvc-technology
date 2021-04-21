package com.te.springmvc2.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc2.beans.EmployeeBean;
import com.te.springmvc2.dao.EmployeeDao;
import com.te.springmvc2.service.EmployeeServiceImpl;

@Controller
public class SpringMVC2Controller {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
		
	}

	@Autowired
	EmployeeServiceImpl service;

	@GetMapping("/login")
	public String getLoginForm() {
		return "loginform";
	}

	@PostMapping("/emplogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {

		EmployeeBean employeeBean = service.authenticate(id, password);

		if (employeeBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeeBean);
			return "homepage";
		} else {
			map.addAttribute("errmsg", "invalid credentials");
			return "loginform";
		}
	}

	@GetMapping("/searchform")
	public String getSearchForm(HttpSession session, ModelMap map) {
		if (session.getAttribute("emp") != null) {
			return "searchform";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "loginform";
		}
	}

	@GetMapping("/search")
	public String searchEmployee(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean employeeBean2 = service.getEmployee(id);
			if (employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);
			} else {
				map.addAttribute("msg", "data not found for id: " + id);
			}
			return "searchform";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "loginform";
		}

	}// end of searchemployee

	@GetMapping("/logout")
	public String logOut(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successful");
		return "loginform";
	}// end of logout

	@GetMapping("/getdeleteform")
	public String getDeleteForm(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			return "deleteform";
		} else {
			map.addAttribute("msg", "please login first");
			return "loginform";
		}

	}

	@GetMapping("/delete")
	public String deleteEmployee(int id, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			ModelMap map) {
		if (bean != null) {
			boolean deleted = service.deleteEmployee(id);
			if (deleted == true) {
				map.addAttribute("msg", "deleted successfully");
				return "deleteform";
			} else {
				map.addAttribute("errmsg", "user not found");
				return "deleteform";
			}

		}

		return null;

	}

	@GetMapping("/viewall")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = service.getAllData();
			map.addAttribute("empdata", employeeBeans);
			return "alldata";
		} else {
			map.addAttribute("msg", "no employees found");
			return "alldata";
		}

	}

	@GetMapping("/addemp")
	public String getAddForm(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			return "addempform";
		} else {
			map.addAttribute("msg", "please login first");
			return "loginform";
		}
	}

	@PostMapping("/add")
	public String addEmployee(EmployeeBean empdata,
			@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			if (service.addEmployee(empdata)) {
				map.addAttribute("msg", "added successfully");
				return "addempform";
			} else {
				map.addAttribute("errmsg", "something went wrong");
				return "addempform";
			}
		} else {
			map.addAttribute("msg", "please login first");
			return "loginform";
		}
	}
	
	@GetMapping("/updateform")
	public String getUpdateForm(@SessionAttribute(name = "emp", required = false)EmployeeBean bean,ModelMap map) {
		if (bean != null) {
			map.addAttribute("id", bean.getId());
			return "updateemp";
		} else {
			map.addAttribute("msg", "please login first");
			return "loginform";
		}
	}
	
	@PostMapping("/update")
	public String updateEmployee(@SessionAttribute(name = "emp",required = false) EmployeeBean bean,ModelMap map,EmployeeBean empdata) {
		if (bean != null) {
			if(service.updateEmployee(empdata)) {
				map.addAttribute("id", bean.getId());
				map.addAttribute("msg", "successfully updated");
				return "updateemp";
			}
			else {
				map.addAttribute("errmsg", "something went wrong");
				return "updateemp";
			}
			
		} else {
			map.addAttribute("msg", "please login first");
			return "loginform";
		}
		
	}

}
