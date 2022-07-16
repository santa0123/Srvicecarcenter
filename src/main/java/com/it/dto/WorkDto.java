package com.it.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class WorkDto {
	private Integer workId;
	private Integer svcId;
	private String wkName;
	private String wkDesc;
	private Blob wkImage;
	private String recordStatus;
	
	
	
	

}
