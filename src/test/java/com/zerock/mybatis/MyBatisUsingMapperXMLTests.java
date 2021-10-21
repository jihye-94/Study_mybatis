package com.zerock.mybatis;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zerock.mybatis.domain.DepartmentsVO;
import com.zerock.mybatis.domain.EmployeeVO;
import com.zerock.mybatis.persistence.EmployeesMapper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

/*
 
 */
@Log4j2
@NoArgsConstructor
public class MyBatisUsingMapperXMLTests {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionFactoryBuilder builder;


	  //1. 히카리CP 적용전
	  
	  @Before
	  public void setup() throws IOException{ log.info("setup() invoked");
	  
	  String mybatisConfigXml = "mybatis-config.xml"; InputStream is =
	  Resources.getResourceAsStream(mybatisConfigXml);
	  
	  try (is){ this.builder = new SqlSessionFactoryBuilder(); //
	  this.sqlSessionFactory = this.builder.build(is);
	  //공장에 is 설정으로	  sqlSessionFactory 만듭니다. 
	  } //try - with - resource
	  
	  //위의 2개 필드의 값이 null 인지 여부 확인 assert this.builder != null; //1. 메서드
	  assertNotNull(this.sqlSessionFactory); //2 메서드
	  Objects.requireNonNull(this.builder); //3 메서드
	  
	  log.info("1. this.builder : {} ", this.builder);
	  log.info("2. this.sqlSessionFactory : {} ", this.sqlSessionFactory); 
	  } //	  setup
	 

	// ---------------------- 히카리CP 적용후 --------------------------//
	// 스프링과 함께 가장 많이 사용되는 DataSource를 제공하는
	// HikariCP 라이브러리를 이용하여 DataSource를 생성하고
	// 이 DataSource를 사용하는 MyBatis 설정을 자바 코드로 구현하고
	// 이 MyBatis 설정을 이용해서 이전과 동일하게
	// SqlSessionFactoryBuilder와 sqlSessionFactory 객체를 얻어내자!
//	@Before
//	public void setup() throws SQLException {
//		log.info("setup() invoked");
//
//		// HikariCP 라이브러리를 이용하여 DataSource를 생성
//		// Step-1. HikariCP의 설정 객체를 생성 및 값을 설정
//		// Step-2. Step1 에서 생성한 HikariCP의 설정을 적용해서 DataSource 생성
//
//		// Step-1. HikariConfig class를 이용해서 설정
//		HikariConfig hikariConfig = new HikariConfig();
//
//		// ---------------------- JDBC 접속 기본 정보 설정--------------------------//
//		// 드라이버 설정
//		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
////        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy"); //DriverSPY로 쓸 경우
//		// Url 설정(ezconnect)
//		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XE");
////        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521/XE\"); //DriverSPY로 쓸 경우
//		// Url 설정(tnsalias)
////        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@XE?TNS_ADMIN=C:/oraclexe/app/oracle/product/11.2.0/server/network/ADMIN");
//		// 계정설정
//		hikariConfig.setUsername("HR");
//		hikariConfig.setPassword("1004");
//
//		//------------------- CP 미세조정 설정 --------------------//
//		hikariConfig.setMaximumPoolSize(10);
//		hikariConfig.setMinimumIdle(3);
//		hikariConfig.setConnectionTimeout(1000);  // 1000ms = 1sec.
//
//		
//		// Step.2 - Step1.에서 생성한 HikariCP의 설정을 적용해서, DS생성
//		HikariDataSource hikariDataSource = 
//				new HikariDataSource(hikariConfig);
//		
//		log.info("2. hikariDataSource: {}", hikariDataSource);
//		
//		//-----------------------------------------------------//
//		
////		MyBatis 설정파일을 안쓰기 때문에, 이 설정파일과 동일한 내용을 가지도록 코딩
//		TransactionFactory transactionFactory=new JdbcTransactionFactory();
//
//		log.info("3. transactionFactory: {}", transactionFactory);
//		
//		Environment env=
//			new Environment(
//				"development", 
//				transactionFactory, 
//				hikariDataSource);
//		log.info("4. env: {}", env);
//		
//		Configuration mybatisConfig=new Configuration(env);
//		
//		mybatisConfig.addMapper(EmployeesMapper.class);
//		
//		//-----------------------------------------------------//
//		this.builder=new SqlSessionFactoryBuilder();
//		this.sqlSessionFactory=builder.build(mybatisConfig);
//		
//		assert this.sqlSessionFactory != null;
//		log.info("4. sqlSessionFactory: {}", this.sqlSessionFactory);
//	} // setup

	@Test
	public void testTemp() {
		;
		;
	}

	// version1
//    @Test(timeout = 2000) //2초 안에 끝나야합니다!
//    public void testSelectAllEmployees(){
//        log.info("testSelectAllEmployees() invoked");
//    
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
//        log.info("3. sqlSession : {}", sqlSession);
//    
//        try (sqlSession){
//        
//            String namespace = "BoardMapper"; // like IP주소 
//            String sqlId = "selectAllEmployees"; // like port번호             
//            // statement = namespace + "." + sqlId
//            String sql = namespace + "." +sqlId; 
//            
//            // 위에서 지정한 sql문장이 오로지 1개의 레코드를 반환하는 경우에는 아래의 메소드 사용 
//            // sqlSession.selectOne(sql);
//            
//            //위에서 지정한 sql문장이 0개이상 여러개의 레코드를 반환하는 경우에는 아래의 메소드 사용 
////            sqlSession.<EmployeeVO>selectList(sql); // 그치만 제네릭 안쓰는게 일반적임 
//            List<EmployeeVO> employees = sqlSession.selectList(sql);
//            log.info("99.여기?");
//            log.info("4. employees : {}", employees);
//            employees.forEach(log::info); //forEach, 모든 요소 순회(람다)             
//            employees.clear(); //비워주기 for GC.
//            
//        } // try-with-resource
//    } // testSelectAllEmployees

	// version2 boardmapper에서 바인드변수명 추가
//	@Test(timeout = 2000) // 2초 안에 끝나야합니다!
	@Test
	public void testSelectAllEmployees() {
		log.info("testSelectAllEmployees() invoked");
		
		SqlSession sqlSession=this.sqlSessionFactory.openSession();
		assert sqlSession != null;		
		try (sqlSession) {
			String namespace = "BoardMapper"; // like IP주소
			String sqlId = "selectAllEmployees"; // like port번호
			String sql = namespace + "." + sqlId;
			// 바인드변수가 하나일 때 ㄱ
//          List<EmployeeVO> employees = sqlSession.selectList(sql, 50);
			// 여기서 두번째 파라미터 200은 바인드변수명에 줄 인자값.

			// 바인드변수가 두개 이상일 때 ㄱ
			// 각 바인드 변수에 줄 값을 가지고 있는 객체를 전달해야한다.
			// 1. method => Map 객체 이용
//          Map<String, Object> params = new HashMap<>();         
//          params.put("name1", 50); 
//          params.put("name2", 5000.0); 
//          
//          log.info("params() invoked" + params);
//          log.info(sqlSession.selectList("BoardMapper.selectAllEmployees", params));
//        List<EmployeeVO> employees = 
//		  sqlSession.selectList("BoardMapper.selectAllEmployees", params);
////          List<EmployeeVO> employees = 
////        		  sqlSession.selectList(sql, params);
//
//          log.info("employees" + employees);
          
			// 2. method -> 자바빈즈객체를 이용

			Params params = new Params();
			log.info("params???"+params);
			params.setName1(50);
			params.setName2(5000.0);
			log.info("????params???"+params);
			log.info("????sqlSession???"+sqlSession);
			log.info("????sqlSession.selectList???"+sqlSession.selectList(sql, params));
			
			List<EmployeeVO> employees = sqlSession.selectList(sql, params);
          
			log.info("4. employees : {}", employees);
			employees.forEach(log::info);
			employees.clear(); // 비워주기 for GC.

		} // try-with-resource
	} // testSelectAllEmployees

	@Test(timeout = 2000) // 2초 안에 끝나야합니다!
	public void testSelectAllDepartments() {
		log.info("testSelectAllDepartments() invoked");

		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		log.info("3. sqlSession : {}", sqlSession);

		try (sqlSession) {

			String namespace = "BoardMapper"; // like IP주소
			String sqlId = "selectAllDepartments"; // like port번호
			// statement = namespace + "." + sqlId
			String sql = namespace + "." + sqlId;

			List<DepartmentsVO> departments = sqlSession.selectList(sql);

			log.info("4. departments : {}", departments);
			departments.forEach(log::info); // forEach, 모든 요소 순회(람다)
			departments.clear(); // 비워주기 for GC.

		} // try-with-resource

	} // testSelectAllDepartments

//    @Test(timeout = 2000) 
//    public void testSelectAllEmployeesByAnnotation(){
//        log.info("testSelectAllEmployeesByAnnotation() invoked");
//    
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
//       	assertNotNull(sqlSession);
//        log.info("1. sqlSession : {}", sqlSession);
//        
//        
//        try (sqlSession){
//        	//우리가 만든  Employees 테이블을 CRUD할 수 있는 추상메소드를 선언한
//        	//자바 인터페이스의 clazz객체를 매개변수(parameter)의 전달인자(arguments)로 준다 
//        	EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class) ; //clazz 객체로 만들기 객체.class
//        	
//        	Objects.requireNonNull(mapper); 
//        	log.info("2. mapper : {}", mapper);
//        	log.info("\t +type : {}", mapper.getClass().getName());
//        	
//        	List<EmployeeVO> employees=mapper.selectAllEmployees(); // selectAllEmployees() 리턴타입은 List<EmployeeVO> 
//        	
//        	assert employees != null; 
////        	log.info("3. employees : {}", employees);
//        	employees.forEach(log::info);
//          
//        	employees.clear(); //비워주기 for GC.
//            
//        } // try-with-resource
//        
//    } // testSelectAllEmployeesByAnnotation

	// 2.
	@Test(timeout = 2000)
	public void testSelectAllEmployeesByAnnotation() {
		log.info("testSelectAllEmployeesByAnnotation() invoked");

		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		assertNotNull(sqlSession);
		log.info("1. sqlSession : {}", sqlSession);

		try (sqlSession) {
			// 우리가 만든 Employees 테이블을 CRUD할 수 있는 추상메소드를 선언한
			// 자바 인터페이스의 clazz객체를 매개변수(parameter)의 전달인자(arguments)로 준다
			EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class); // clazz 객체로 만들기 객체.class

			Objects.requireNonNull(mapper);
			log.info("2. mapper : {}", mapper);
			log.info("\t +type : {}", mapper.getClass().getName());

			List<EmployeeVO> employees = mapper.selectAllEmployees(10000); // selectAllEmployees() 리턴타입은
																			// List<EmployeeVO>

			assert employees != null;
//        	log.info("3. employees : {}", employees);
			employees.forEach(log::info);

			employees.clear(); // 비워주기 for GC.

		} // try-with-resource

	} // testSelectAllEmployeesByAnnotation

	@Test
	public void selectNow() {
		log.info("selectNow() invoked");

		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		assertNotNull(sqlSession);
		log.info("1. sqlSession : {}", sqlSession);

		try (sqlSession) {
			// 우리가 만든 Employees 테이블을 CRUD할 수 있는 추상메소드를 선언한
			// 자바 인터페이스의 clazz객체를 매개변수(parameter)의 전달인자(arguments)로 준다
			EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class); // clazz 객체로 만들기 객체.class

			Objects.requireNonNull(mapper);
			log.info("2. mapper : {}", mapper);
			log.info("\t +type : {}", mapper.getClass().getName());

			Timestamp now = mapper.selectNow(); // selectAllEmployees() 리턴타입은 List<EmployeeVO>

			assert now != null;
			log.info("3. now : {}", now);

		} // try-with-resource

	} // selectNow

	@After
	public void after() {
		log.info("after after");
	}// after

}

@Data
@NoArgsConstructor
class Params {
	private int name1;
	private double name2;
}
