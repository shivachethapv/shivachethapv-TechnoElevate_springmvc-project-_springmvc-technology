package com.te.springmvc2.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeBean implements Serializable{

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column(name = "dob")
	private Date birtDate;
	
	@Column
	private String password;
}
