package com.symum.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {"com.symum.springcoredemo",
//				            "com.symum.util"
//		} // if the class and component is saved to another folder in the subfolder we have to define the annotation to scan the folder manually.
//)

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
