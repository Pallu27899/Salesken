package com.salesken.pallu.service;

import java.util.List;

import com.salesken.pallu.DTO.StudentDto;
import com.salesken.pallu.DTO.SubjectsDetailsDto;
import com.salesken.pallu.exception.StudentException;
import com.salesken.pallu.exception.SubjectDetailsException;
import com.salesken.pallu.model.Student;

public interface StudentInterface {

	
	Student registerStudent(StudentDto studentDto)throws StudentException;
	List<StudentDto> getAllStudent()throws StudentException;
	StudentDto findStudentById(Integer studentId)throws StudentException;
	
}
