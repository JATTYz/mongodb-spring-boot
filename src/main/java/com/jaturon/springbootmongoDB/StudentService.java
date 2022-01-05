package com.jaturon.springbootmongoDB;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student){

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Student already exists");
        }

        return studentRepository.save(student);
    }

    public void deleteStudentById(String id){
        studentRepository.deleteById(id);
    }

    public Student updateStudent(String id, Student student){
                studentRepository.deleteById(id);
        return studentRepository.save(student);
    }
}
