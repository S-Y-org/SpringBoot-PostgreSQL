package com.springbootpostresql.SpringBootPostgreSQL.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

//@Component - @Component and @Service do the same thing. We use @Service for more readability.
//When we see the @Service , we know that the class is meant to be a service class
@Service
public class StudentService {

    private static StudentRepository studentRepository;
//    private final StudentRepository studentRepository;  I had to remove
//    this code becuz final variable gave me conflicts with the public static void addNewStudent(Student student) method


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    public static void addNewStudent(Student student) {
        Optional<Student> studentOptional =  studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw  new IllegalStateException("Student with id " +studentId
                    + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}//end of StudentService Class


//NOTES:

/*

In Java, `IllegalStateException` is a type of exception that is thrown to indicate an illegal state in the application or object. It is a subclass of `RuntimeException` and belongs to the unchecked exception category, which means it does not need to be explicitly declared in a method's throws clause or caught in a try-catch block.

An `IllegalStateException` typically occurs when a method is called or an operation is performed on an object in a state that is not valid or expected. It indicates that the application or object is in an inappropriate or illegal state to perform the requested operation.

Some common scenarios where an `IllegalStateException` may be thrown include:

- Calling a method before initializing or configuring an object properly.
- Invoking a method at an incorrect time or in an incorrect order.
- Performing an operation that violates the rules or constraints of an object's state.

When an `IllegalStateException` is thrown, it usually indicates a programming error or misuse of APIs. It is important to handle or catch the exception appropriately to provide meaningful error messages or take necessary corrective actions.

Here's an example of how an `IllegalStateException` can be thrown:


public class MyClass {
    private boolean initialized = false;

    public void initialize() {
        if (initialized) {
            throw new IllegalStateException("Already initialized");
        }

        // Perform initialization logic...

        initialized = true;
    }

    public void performOperation() {
        if (!initialized) {
            throw new IllegalStateException("Not initialized");
        }

        // Perform the operation...
    }
}


In the above example, calling the `initialize()` method multiple times or calling the `performOperation()` method before initializing the object will result in an `IllegalStateException` being thrown.


*/