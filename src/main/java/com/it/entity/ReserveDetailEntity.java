package com.it.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_reserve_detail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDetailEntity implements Serializable{

	private static final long serialVersionUID = 4361284435074078038L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer resdeId;
	
	@Column(name="svc_id")
	private Integer svcId;
	
	@Column(name="reserve_id")
	private Integer reserveId;
	
	@Column(name="work_id")
	private Integer workId;
	
	@Column(name="book_start_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
	private Timestamp bookStartDate;
	
	@Column(name="book_end_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
	private Timestamp bookEndDate;
	
	@Column(name="record_status")
    private String recordStatus;
	
	@Column(name="creat_by")
    private String creatBy;
	
	@CreationTimestamp
	@Column(name="creat_date" , nullable = false , updatable = false)
    private Timestamp creatDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@UpdateTimestamp
	@Column(name="update_date",nullable = false , updatable = false)
    private Timestamp updateDate;
	
	
	
	

}
