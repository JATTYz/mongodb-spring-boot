package com.jaturon.springbootmongoDB;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createNewStudent(Student student){
        return studentService.addNewStudent(student);
    }

    @DeleteMapping
    public void deleteStudentById(String id){
        studentService.deleteStudentById(id);
    }

    @PutMapping
    public Student updateStudent(String id, Student student){
       return   studentService.updateStudent(id,student);
    }
}
