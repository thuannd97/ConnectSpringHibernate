package com.thuannd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thuannd.dao.StudentDao;
import com.thuannd.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
	}

	@Transactional
	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.editStudent(student);
	}

	@Transactional
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentId);
	}

	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

}
