package com.te.springmvc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable{
	
	private int pswd;
	
	private String user;

}
