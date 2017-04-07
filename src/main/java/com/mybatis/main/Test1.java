package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis.pojo.Teacher;

public class Test1 {
	
	private static Logger logger = LoggerFactory.getLogger(Test1.class);

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			List<Teacher> lists = session.selectList("selectTeacher");
			for (Teacher teacher : lists) {
				System.out.println(teacher.getName());
			}
			logger.info("hello{}", 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			is.close();
		}
	}
	
}
