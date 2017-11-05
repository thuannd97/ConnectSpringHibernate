package com.thuannd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuannd.model.Student;
import com.thuannd.service.StudentService;
import com.thuannd.service.StudentServiceImpl;

@Controller

public class HomeController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String getViewHome(Map<String, Object> map) {
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "home";
	}

	@RequestMapping(value = "/student.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action,
			ModelMap map) {
		Student studentResult = new Student();
		switch (action.toLowerCase()) {
		case "add":
			studentService.addStudent(student);
			studentResult = student;
			break;
		case "edit":
			studentService.editStudent(student);
			studentResult = student;
			break;
		case "delete":
			studentService.deleteStudent(student.getId());
			studentResult = new Student();
			break;
		case "search":
			break;
		}
		map.addAttribute("student", studentResult);
		map.addAttribute("studentList", studentService.getAllStudent());
		// map.put("student", studentResult);
		// map.put("studentList", studentService.getAllStudent());
		return "home";
	}
}
