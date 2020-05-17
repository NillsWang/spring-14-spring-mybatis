package com.wmz.service;

import java.util.ArrayList;
import java.util.List;

import com.wmz.bean.Student;
import com.wmz.dao.StudentDao;

public class StudentServiceImpl implements IStudentService {
	
	//由spring容器注入，所以需要添加set()方法，由容器注入属性
	private StudentDao dao;
		
	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);	
	}

	@Override
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

	@Override
	public void removeStudent(Student student) {
		dao.deleteStudent(student);
	}

	@Override
	public List<String> findAllStudentsNames() {
		List<String> names = new ArrayList<>();
		List<Student> students = this.findAllStudents();
		for (Student student : students) {
			names.add(student.getName());
		}
		return names;
	}

	@Override
	public String findStudentNameById(int id) {
		Student student = this.findStudentById(id);
		return student.getName();
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.selectAllStudents();
	}

	@Override
	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}

}
