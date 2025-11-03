package com.example.demo.Entity;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String uname;
	
	private String uaddress;
	
	private String country;
	
	private String emailId;


}
