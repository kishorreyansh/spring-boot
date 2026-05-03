package com.springboot.service;

import com.springboot.dto.AddNewStudentDto;
import com.springboot.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddNewStudentDto addNewStudentDto);

    void deleteStudentById(Long id);
}
