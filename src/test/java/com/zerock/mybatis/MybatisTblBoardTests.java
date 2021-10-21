package com.zerock.mybatis;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zerock.mybatis.domain.TblBoardVO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class MybatisTblBoardTests {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSessionFactoryBuilder builder;
	private final String namespace = "TblBoardMapper"; // like IP주소
	// 1. 히카리CP 적용전
//	@Before
//	public void setup() throws IOException {
//		log.info("setup() invoked");
//
//		String mybatisConfigXml = "mybatis-config-admin.xml";
//		InputStream is = Resources.getResourceAsStream(mybatisConfigXml);
//
//		try (is) {
//			this.builder = new SqlSessionFactoryBuilder(); //
//			this.sqlSessionFactory = this.builder.build(is);
//			// 공장에 is 설정으로 sqlSessionFactory 만듭니다.
//		} // try - with - resource
//
//		// 위의 2개 필드의 값이 null 인지 여부 확인 assert this.builder != null; //1. 메서드
//		assertNotNull(this.sqlSessionFactory); // 2 메서드
//		Objects.requireNonNull(this.builder); // 3 메서드
//
//		log.info("1. this.builder : {} ", this.builder);
//		log.info("2. this.sqlSessionFactory : {} ", this.sqlSessionFactory);
//	} // setup

	@Before
	public void setup() throws IOException  {
		log.debug("setup() invoked");
		
		this.builder = new SqlSessionFactoryBuilder(); //
		Objects.requireNonNull(this.builder);
				
		//1. 메소드 
//		InputStream is = new FileInputStream("C:/app/workspace/jee/mybatis/src/main/resources/mybatis-config-admin.xml");
		//2. 메소드 
		InputStream is = Resources.getResourceAsStream("mybatis-config-admin.xml"); 
		
		this.sqlSessionFactory = this.builder.build(is);
		assertNotNull(sqlSessionFactory);	
	} // setup
	
	//----------------------------------------------------//

	@Test
	public void testSelectAllBoards() {
		log.debug("testSelectAllBoards() invoked.");
		
		String sqlId = "selectAllBoards"; // like port번호

		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			String sql = namespace + "." + sqlId;

			List<TblBoardVO> list = sqlSession.selectList(sql);

			list.forEach(log::info);
			list.clear(); // 비워주기 for GC.

		} // try-with-resource
	} // testSelectAllBoards
	
	//----------------------------------------------------//

	@Test
	public void testSelectBoard() {
		log.info("testSelectAllBoards() invoked.");

		String sqlId = "selectBoard"; // like port번호

		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			String sql = namespace + "." + sqlId;
			Integer param = 777 ;
			TblBoardVO board = sqlSession.selectOne(sql, param);

			log.info("boards : {}", board);


		} // try-with-resource
	} // testSelectBoard
	
	//----------------------------------------------------//

	@Test
	public void testFindBoardByBno() {
		log.info("testFindBoardsByTitle() invoked.");
		
		String sqlId = "findBoardByBno"; // like port번호
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();	
		try (sqlSession) {
			String sql = namespace + "." + sqlId;
			Integer param = 777 ;
			
			TblBoardVO board = sqlSession.selectOne(sql, param);

			log.info("boards : {}", board);

		} // try-with-resource
	} // testFindBoardByBno
	
	//----------------------------------------------------//

	@Test
	public void testFindBoardsByTitle() {
		log.info("testSelectAllBoards() invoked.");

		String sqlId = "findBoardsByTitle"; // like port번호
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			String sql = namespace + "." + sqlId;
			String param = "7"; 

			List<TblBoardVO> list = sqlSession.selectList(sql, param);

			list.forEach(log::info);
			list.clear(); // 비워주기 for GC.

		} // try-with-resource
	} // testFindBoardsByTitle
	
	//----------------------------------------------------//

	@After
	public void tearDown() {
		log.info("tearDown() invoked.");
	} // tearDown

} // end class
