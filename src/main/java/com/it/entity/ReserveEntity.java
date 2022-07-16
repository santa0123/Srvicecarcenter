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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_reserve")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveEntity implements Serializable{


	private static final long serialVersionUID = -842910781880856087L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reserveId;
	
	@Column(name="scv_id")
	private Integer scvId;
	
	@Column(name="user_id")
	private Integer userId;
	
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
