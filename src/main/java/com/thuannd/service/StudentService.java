package com.thuannd.service;

import java.util.List;

import com.thuannd.model.Student;

public interface StudentService {
	public void addStudent(Student student);

	public void editStudent(Student student);

	public void deleteStudent(int studentId);

	public Student getStudent(int studentId);

	public List<Student> getAllStudent();
}
