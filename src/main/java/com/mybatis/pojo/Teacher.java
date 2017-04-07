package com.mybatis.pojo;

import java.util.List;

/**
 * 老师
 * @author DN
 *
 */
public class Teacher {

	private int id;
	private String name;
	private Book book;
	private List<Student> students;
	private int status;
	private List<Integer> list;
	
	public Teacher(){};
	
	public Teacher(String name) {
		this.name = name;
	}
	
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
