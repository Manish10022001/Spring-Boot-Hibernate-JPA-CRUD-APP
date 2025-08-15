package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*
Step 1: Create entity class to connect to database table
        -> Define fields
        -> Default constructor, parameterized constructor
        -> Getter and Setter
        -> toString() method

Step 2: Define DAO interface (Student interface)
        ->Create new package: dao
            -> Create a new interface: StudentDAO -> abstract method

Step 3: Define DAO implementation (studentDAOImpl class)
        -> create a new class: StudentDAOimpl
            ->define field for entity manager
            ->Inject entity manager using constructor injection
            ->implement save method -> add @Transactional as we add and remove data
                                    -> to save entityManger.persist(theStudent)
       -> Inject the entity manager

Step 4: Update main app
        -> inject StudentDAO in bean
        -> in return write custom code and pass studentDao to createStudent table
        -> create method createStudent(reference)
            ->create student object
            ->save the student object
            ->display id of the saved student
   */


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }
/*You didn't create any other Spring components (like @Component, @Service, etc.).
You're not using a web controller (@RestController).
You're just running some startup logic in the command line.
CommandLineRunner is called automatically by Spring Boot, but only if it's a Spring Bean.

next step connect to database in application.properties


        @Bean
        public CommandLineRunner commandLineRunner(String[] args){
            return runner ->{
                System.out.println("Hello world");
            };
        }

	}

*/

    @Bean                                      //Inject StudentDAO
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

        return runner ->{
            //add custom code to create student
            createStudent(studentDAO);
        };
    }

    public void createStudent(StudentDAO studentDAO){
        //create the student Object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Lionel","Messi","thegoat@gmail.com");

        //Save the student Object
        studentDAO.save(tempStudent);

        //Display the id of saved student
        System.out.println("Saved Student. Generated id: "+tempStudent.getId());
    }
}


