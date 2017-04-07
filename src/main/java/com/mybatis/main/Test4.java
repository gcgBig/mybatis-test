package com.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Teacher;

public class Test4 {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		SqlSessionFactory sessionFactory = null;
		SqlSession session = null;
		try {
			is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
			session = sessionFactory.openSession();
			List<Teacher> lists = new ArrayList<Teacher>();
			lists.add(new Teacher("lala"));
			lists.add(new Teacher("didi"));
			session.insert("batchInsert", lists);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			is.close();
		}
	}

}
