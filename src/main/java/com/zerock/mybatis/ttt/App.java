package com.zerock.mybatis.ttt;

import java.lang.reflect.Field;
import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor
public class App {


	public static void main(String[] args) 
			throws ClassNotFoundException {
		
		// 1. A타입의 clazz 객체 얻어내기 
		// 	(1) 타입명.class 
		//	(2) 참조변수.getClass()
		//	(3) Class.forName("FQCN")
		
//		// 	(1) 타입명.class 
////		Class clazz = A.class; X
//		
////		(2) 참조변수.getClass()
//		A a = new A();
//		Class<?> clazz = a.getClass();
//		
////		(3) Class.forName("FQCN")
////		Class<?> clazz = Class.forName("com.zerock.mybatis.ttt.A");
//		
//		log.info("- clazz: {}", clazz);
		
		Class clazz = Person.class;
		log.info("- clazz: {}", clazz);
		
		Field[] allFields = clazz.getDeclaredFields();
		log.info(Arrays.toString(allFields));
	} //main

} // end class 

class Person {
	String name; 
	int age; 
}

class A {;;} // end class 

class B {;;} // end class 

class C {;;} // enb class 
