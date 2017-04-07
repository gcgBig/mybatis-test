package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Student;

public class Test5 {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			List<Student> lists = new ArrayList<Student>();
			Student student = new Student("啊", "0");
			lists = session.selectList("getStudentTest", student);
			for (Student student2 : lists) {
				System.out.println(student2.getName());
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			is.close();
		}
	}

}
