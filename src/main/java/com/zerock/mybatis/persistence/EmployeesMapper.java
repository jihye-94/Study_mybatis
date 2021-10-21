package com.zerock.mybatis.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zerock.mybatis.domain.EmployeeVO;

public interface EmployeesMapper {

//	@Select("SELECT /*+ index_asc(employees)*/ * FROM employees")
//	public abstract List<EmployeeVO> selectAllEmployees(); // 인터페이스 public abstract 생략말고 기재할 것 
	
	//@Param 어노테이션을 바인드변수와 활용
	@Select("SELECT /*+ index_asc(employees)*/ * FROM employees WHERE salary > #{salary}")
//	@Select("SELECT /*+ index_asc(employees)*/ * FROM employees "
//			+ "WHERE employee_id > #{name1}"
//			+ "	AND SALARY > #{name2}"
//			+ "	AND commission_pct IS NOT NULL")
	public abstract List<EmployeeVO> selectAllEmployees(@Param("salary") double ttt); // 인터페이스 public abstract 생략말고 기재할 것 
	
//	public abstract List<EmployeeVO> selectAllEmployees(@Param("name1") int name1, @Param("name2") double name2); // 인터페이스 public abstract 생략말고 기재할 것 

	@Select("SELECT sysdate FROM dual")
	public abstract Timestamp selectNow(); 

} // end interface 
