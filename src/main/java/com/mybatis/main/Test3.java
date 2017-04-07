package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Teacher;

public class Test3 {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			Teacher teacher = new Teacher();
			teacher.setName("葛晨光");
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			teacher.setList(list);
			/*teacher = session.selectOne("getTeacherAndBook", teacher);
			System.out.println(teacher.getStudents().size());*/
			List<Teacher> lists = session.selectList("getTeacher", teacher);
			for (Teacher teacher2 : lists) {
				System.out.println(teacher2.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			is.close();
		}
	}

}
