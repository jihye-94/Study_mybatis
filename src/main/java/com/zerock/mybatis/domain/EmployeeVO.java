package com.zerock.mybatis.domain;

import java.util.Date;

import lombok.Value;

@Value
public class EmployeeVO {

	// 한 명의 사원 정보를 저장하는 필드를 선언
	// 모든 필드는 읽기 전용이니까 private 
	// null처리해야하니까 참조형 
	
	private Integer employeeId; 
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber; 
	private Date hireDate; 
	private String jobId;
	private Double salary; 
	private Double commissionPct; 
	private Integer managerId; 
	private Integer departmentId; 

	
} // end class 
