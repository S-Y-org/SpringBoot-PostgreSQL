package com.springbootpostresql.SpringBootPostgreSQL.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return  args -> {
            Student yeran = new Student(
                    "Yeran",
                    "yk@gmail.com",
                    LocalDate.of(2000, SEPTEMBER, 21),
                    21
            );
            Student vinu = new Student(
                    "vinu",
                    "va@gmail.com",
                    LocalDate.of(2004, OCTOBER, 11),
                    19
            );

            repository.saveAll(
                    List.of(yeran, vinu)
            );
        };
    }
}

//NOTES

/*
(Q)What is the use of ;
return  args -> {};

The code snippet `return args -> {};` represents a lambda expression in Java. In this specific case, it is an implementation of a functional interface that takes an array of arguments (`args`) and returns nothing (void).

Lambda expressions were introduced in Java 8 and provide a concise way to represent functional interfaces, which are interfaces with a single abstract method. By using lambda expressions, you can write more compact and expressive code for functional programming in Java.

In the given code snippet, `args -> {}` defines an anonymous function that takes an array of arguments (`args`) and performs no action inside the function body. The `{}` indicates an empty block of code. This lambda expression can be used as a placeholder for any functional interface that accepts an array of arguments and does not have a return value.

It's worth noting that without further context, it is difficult to determine the exact purpose and usage of this lambda expression. The specific use case and surrounding code would provide more insights into its functionality.
======================================================================================

(Q)whats the ->

In Java, the arrow (->) is called the lambda operator and is used to define lambda expressions. Lambda expressions are a concise way to represent anonymous functions or methods.

The general syntax of a lambda expression is (parameters) -> { body }, where:

parameters represent the input parameters of the function.
-> is the lambda operator, which separates the parameters from the body of the lambda expression.
{ body } represents the implementation of the function, which can be a single statement or a block of statements.
The lambda operator -> essentially denotes "goes to" and serves as a shorthand notation for defining functions without the need for explicit method declarations or anonymous inner classes.

For example, consider the following lambda expression:
(x, y) -> x + y

In this case, (x, y) represents the input parameters, and x + y is the body of the lambda expression. This lambda expression can be assigned to a functional interface and used as a compact representation of a function that takes two parameters and returns their sum.

Lambda expressions in Java provide a more concise and expressive way to work with functional programming concepts and enable functional-style programming paradigms.






 */
