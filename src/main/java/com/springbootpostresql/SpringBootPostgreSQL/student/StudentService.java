package com.springbootpostresql.SpringBootPostgreSQL.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Component - @Component and @Service do the same thing. We use @Service for more readability.
//When we see the @Service , we know that the class is meant to be a service class
@Service
public class StudentService {

    private final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }
}//end of StudentService Class
