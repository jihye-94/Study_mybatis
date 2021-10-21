package com.zerock.mybatis.domain;

import java.util.Date;

import lombok.Value;

@Value
public class TblBoardVO {
	/*
	BNO       NOT NULL NUMBER         
	TITLE     NOT NULL VARCHAR2(200)  
	CONTENT   NOT NULL VARCHAR2(2000) 
	WRITER    NOT NULL VARCHAR2(50)   
	INSERT_TS NOT NULL TIMESTAMP(6)   	
	UPDATE_TS          TIMESTAMP(6)   */
	private Integer bno; 
	private String title;
	private String content;
	private String writer;
//	private Date insertTs; 
//	private Date updateTs;

	
} // end class 
