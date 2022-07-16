package com.it.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import com.it.utils.TimestampSerializer;

@Data
public class ReserveDetailDto implements Serializable{
	

	private static final long serialVersionUID = -2618445816694819312L;
	
	private Integer resdeId;
	private Integer scvId;
	private Integer reserveId;
	private Integer workId;
	
	@JsonSerialize(using = TimestampSerializer.class)
	private Timestamp bookStartDate;
	@JsonSerialize(using = TimestampSerializer.class)
	private Timestamp bookEndDate;
	private String recordStatus;
	

	
}
