package com.springboot.service.impl;

import com.springboot.dto.AddNewStudentDto;
import com.springboot.dto.StudentDto;
import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().
                map(student ->
                new StudentDto(student.getId(),student.getName(), student.getEmail())).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student Id not Found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddNewStudentDto addNewStudentDto) {
        Student newStudent = modelMapper.map(addNewStudentDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student Id Doesn't exists: "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(Long id, AddNewStudentDto addNewStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found: "+id));
        modelMapper.map(addNewStudentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudentData(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found: "+id));
        updates.forEach((String field, Object value) -> {
            switch(field){
                case "name":
                    student.setName((String)value);
                    break;
                case "email":
                    student.setEmail((String)value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not available");
            }
        });
        Student newStudent = studentRepository.save(student);
        return modelMapper.map(newStudent, StudentDto.class);
    }


}
