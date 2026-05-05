package com.springboot.service;

import com.springboot.dto.AddNewStudentDto;
import com.springboot.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddNewStudentDto addNewStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateStudentById(Long id, AddNewStudentDto addNewStudentDto);

    StudentDto updatePartialStudentData(Long id, Map<String, Object> fields);
}
