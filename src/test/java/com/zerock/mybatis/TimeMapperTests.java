package com.zerock.mybatis;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
import com.zerock.mybatis.persistence.TimeMapper;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class TimeMapperTests {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setup() throws IOException  {
		log.debug("setup() invoked");

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); //
		Objects.requireNonNull(builder);
				

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml"); 
		
		this.sqlSessionFactory = builder.build(is);
		assertNotNull(sqlSessionFactory);	
	} // setup
	
	//----------------------------------------------------//

	@Test
	public void testGetNow() {
		log.debug("testGetNow() invoked.");				
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			
			TimeMapper mapper = sqlSession.getMapper(TimeMapper.class); 
			String now = mapper.getNow();
			log.info(now);

		} // try-with-resource
	} // testGetNow		
	
	//----------------------------------------------------//

	//2. 기존방식으로 호출하기
	/*
	@Test
	public void testGetNow2() {
		log.debug("testGetNow2() invoked.");				
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			
			String namespace = "com.zerock.mybatis.persistence.TimeMapper";
			String sqlId = "getNow2"; 			
			String sql = namespace + "." + sqlId; 
			
			String now = sqlSession.selectOne(sql); 
			
			log.info(now);			

		} // try-with-resource
	} // testGetNow2		
	*/
	
	@Test
	public void testGetNow2() {
		log.debug("testGetNow2() invoked.");				
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		try (sqlSession) {
			
			TimeMapper mapper = sqlSession.getMapper(TimeMapper.class); 
//			String now = mapper.getNow2();
			Date now = mapper.getNow2();
			log.info(now);

		} // try-with-resource
	} // testGetNow2	
	

} // end class
