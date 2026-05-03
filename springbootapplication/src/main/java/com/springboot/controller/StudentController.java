package com.springboot.controller;

import com.springboot.dto.AddNewStudentDto;
import com.springboot.dto.StudentDto;
import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;
import com.springboot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*@GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1L,"Reyansh","reyansh@gmail.com");
    }*/

    /*@GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }*/

    //Using ResponseEntity
    //@GetMapping("/students")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
        // another way without using body
        //return ResponseEntity.ok(studentService.getAllStudents());
    }

    /*@GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }*/
    //@GetMapping("/students/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddNewStudentDto addNewStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addNewStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
