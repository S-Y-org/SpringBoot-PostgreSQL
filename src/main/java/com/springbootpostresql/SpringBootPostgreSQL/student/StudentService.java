package com.springbootpostresql.SpringBootPostgreSQL.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Component - @Component and @Service do the same thing. We use @Service for more readability.
//When we see the @Service , we know that the class is meant to be a service class
@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Yeran",
                        "yk@gmail.com",
                        LocalDate.of(2000, Month.SEPTEMBER, 21),
                        21
                )
        );
    }
}//end of StudentService Class
