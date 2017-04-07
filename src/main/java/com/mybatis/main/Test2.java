package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Teacher;

public class Test2 {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			Teacher teacher = new Teacher();
			// teacher.setId(3);
			teacher.setName("葛晨光");
			// int result = session.insert("saveTeacher", teacher);
			int result = session.insert("saveByRandom", teacher);
			// int result = session.update("update", teacher);
			// int result = session.delete("delete", teacher);
			session.commit();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			is.close();
		}
	}

}
