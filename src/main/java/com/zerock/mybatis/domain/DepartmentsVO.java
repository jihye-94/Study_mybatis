package com.zerock.mybatis.domain;

import lombok.Value;

@Value
public class DepartmentsVO {

/*
 DEPARTMENT_ID
DEPARTMENT_NAME
MANAGER_ID
LOCATION_ID 
 */
	
	private Integer departmentId; 
	private String departmentName;
	private Integer managerId; 
	private Integer locationId;

	
} // end class 
