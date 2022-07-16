package com.it.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class UserDetailDto {
	
	private Integer userdeId;
	private String username;
	private String fristName;
	private String lastName;
	private String svcName;
	private Blob svcDocument;
	private String address;
	private String zibId;
	private Integer tcode;
	private Integer acode;
	private Integer pcode;
	private String district;
	private String provice;
	private String phone;
	private String email;
	private Blob userImg;
	private String recordStatus;
	
	 
	
	
	
	
	
	
	
	
	
	
}
