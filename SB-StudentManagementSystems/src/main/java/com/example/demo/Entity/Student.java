package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private String sid;
	
	private String sname;
	
	private String saddress;
	
	private String prn;
	
	private String emailId;
	
	private String mobileNo;

}
