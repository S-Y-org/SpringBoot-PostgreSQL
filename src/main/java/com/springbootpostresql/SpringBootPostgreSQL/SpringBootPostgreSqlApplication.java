package com.springbootpostresql.SpringBootPostgreSQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootPostgreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgreSqlApplication.class, args);
	}

//	@GetMapping("/")
//	public String hello(){
//		return "Hello World";
//	}
	//Small Note : In @GetMapping , if u just put it without defining a URL, it means the GET request is happening
	//from the root URL. We dont need to explicitly write ("/")
	//BUT the thing is now it doesnt work, I dont know why. Still searching
	//When I explicilty defining the root URL ("/") only the Hello World output comes.
	//In youtube vids they dont specifiy the root URL, it works for them.
	//But no for me


	//Using a List, we can get the same output in JSON array format.
	@GetMapping("/")
	public List<String> hello(){
		return  List.of("Hello", "World");
	}

}//End of Class SpringBootPostgreSqlApplication
