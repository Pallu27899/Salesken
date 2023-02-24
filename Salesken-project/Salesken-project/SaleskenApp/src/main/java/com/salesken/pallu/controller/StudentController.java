package com.salesken.pallu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.pallu.DTO.StudentDto;
import com.salesken.pallu.DTO.SubjectsDetailsDto;
import com.salesken.pallu.exception.StudentException;
import com.salesken.pallu.exception.SubjectDetailsException;
import com.salesken.pallu.model.Student;
import com.salesken.pallu.service.StudentInterface;
import com.salesken.pallu.service.SubjectsDetailsInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentInterface studentInterface;
	
	@Autowired
	private SubjectsDetailsInterface subjectsDetailsInterface;
	
	
	@PostMapping("/save")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDto student) throws StudentException{
		Student registerStudent = studentInterface.registerStudent(student) ;
		return new ResponseEntity<Student>(registerStudent,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/all")
	
	public ResponseEntity<List<StudentDto>> getAllStudent() throws StudentException{
		return ResponseEntity.ok(this.studentInterface.getAllStudent());

	}
	
	@GetMapping("/getAveragePercentageOfRecentSemester")
	 public ResponseEntity<Double> getAverageOfRecentSemester() throws SubjectDetailsException{
		 return new ResponseEntity<Double>(subjectsDetailsInterface.getAveragePercentageOfRecentSemester(),HttpStatus.OK);
	 }
	
	@GetMapping("/averageMarksOfStudents")
	 public ResponseEntity<List<Object[]>> getaverageMarksOfStudents() throws SubjectDetailsException{
		return new ResponseEntity<List<Object[]>>(subjectsDetailsInterface.averageMarksOfStudents(),HttpStatus.OK);
	 }
	@GetMapping("/top2ConsistentStudents")
	 public ResponseEntity<List<Object[]>> gettop2ConsistentStudents() throws SubjectDetailsException{
		return new ResponseEntity<List<Object[]>>(subjectsDetailsInterface.top2ConsistentStudents(),HttpStatus.OK);
	 }
}
