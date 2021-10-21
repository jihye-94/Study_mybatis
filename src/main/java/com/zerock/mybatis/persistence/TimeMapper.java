package com.zerock.mybatis.persistence;

import java.util.Date;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {

   // 인터페이스와 SQL Mapper XML 파일과의 결합방식으로 SQL문장 처리
   // 필수조건:
   //    (1) 이 인터페이스가 소속된 패키지와 동일한 폴더구조를 resources 폴더에 만들어야 한다!
   //    (2) (1)에서 생성된 마지막 폴더 안에, 이 인터페이스 이름과 동일한 SQL Mapper XML 파일을 생성!
   //    (3) (2)에서 생성한 SQL Mapper XML파일의 namespace는 **패키지이름+인터페이스이름** 과 동일하게 작성
   //    (4) 수행시킬 SQL ID는, 이 추상메소드의 이름과 같게 작성
	
	@Select("SELECT sysdate FROM dual")
	public abstract String getNow(); //getNow() 호출시 @Select("SELECT sysdate FROM dual") 값 반환 
	
//	public abstract String getNow2(); // XML Mapper 
	public abstract Date getNow2(); // XML Mapper 
	
} // end interface 
