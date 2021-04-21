package com.te.springmvc2.service;

import java.util.Date;

import com.te.springmvc2.beans.EmployeeBean;

public interface EmployeeService {

public EmployeeBean authenticate(int id,String pwd);
	
	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmployee(int id);
	
	public java.util.List<EmployeeBean> getAllData();
	
	public boolean addEmployee(EmployeeBean bean);
	
	public boolean updateEmployee(EmployeeBean bean);
}
