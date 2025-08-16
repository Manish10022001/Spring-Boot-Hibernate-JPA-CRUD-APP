package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
/* Two Save data in table
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

/* Read/retrieve data from table
Step 5: Add new method to dao interface

step 6: Add new method to dao implementation

step 7: update the main app
 */

/* Quering the object with jpa
step 8: Add new method to dao interface
step 9: Add new method to dao implementation
step 10: update the main app
 */

/* Update a student
fist we find the oject by using entityManager.find, then call setter method to actually change the value
step 11: Add new method to dao interface
step 12: Add new method to dao implementation
step 13: update the main app
 */

/*Delete a Student

 */
/* Delete all data from table

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
           // createStudent(studentDAO);

            createMultipleStudent(studentDAO);

            //read or retrieve
           // readStudent(studentDAO);

            // queryForStudent(studentDAO);

            // queryForStudentByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAllStudents(studentDAO);
        };
    }
    public void deleteAllStudents(StudentDAO studentDAO){
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: "+numRowsDeleted);
    }
    public void deleteStudent(StudentDAO studentDAO){
        int studentId = 2;
        System.out.println("Deleting student id: "+studentId);
        studentDAO.delete(studentId);
    }

    public void updateStudent(StudentDAO studentDAO){
        //retrieve student based on the id: primary key
        int theStudentID = 1;
        System.out.println("The student ID is: "+theStudentID);
        Student myStudent = studentDAO.findById(theStudentID);

        // change email to "manish@gmail.com"
        System.out.println("Updating student...");
        myStudent.setEmail("manish@gmail.com");

        //update the student
        studentDAO.update(myStudent);

        //display the updated student
        System.out.println("Updated student: "+myStudent);
    }

    public void queryForStudentByLastName(StudentDAO studentDAO){
        List<Student> theStudent = studentDAO.findByLastName("Messi");
        for(Student tempStudent : theStudent){
            System.out.println(tempStudent);
        }
    }

    public void queryForStudent(StudentDAO studentDAO){

        //get a list of students
        List<Student> theStudent = studentDAO.findAll();

        //display a list of students
        for(Student tempStudent : theStudent){
            System.out.println(tempStudent);
        }
    }

    public void readStudent(StudentDAO studentDAO){
        //find directly by id number
        Student myStudent = studentDAO.findById(3);
        System.out.println("Student "+myStudent);

        /*
        //create the student Object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Lionel","Messi","thegoat@gmail.com");

        //Save the student Object
        studentDAO.save(tempStudent);

        //display the id of saved student
        int theId = tempStudent.getId();
        System.out.println("Saved Student. Generated id: "+theId);

        //retrieve the student based of id: primary key
        System.out.println("Retrieving student with id : "+theId);
        Student myStudent1 = studentDAO.findById(theId);

        //display the student
        System.out.println("found the student "+myStudent1);
         */
    }

    public void createMultipleStudent(StudentDAO studentDAO){
        //create multiple student object
        Student tempStudent = new Student("Rodrigo","DePaul","engine@gmail.com");
        Student tempStudent2 = new Student("Lisandro","Martinez","butcher@gmail.com");
        Student tempStudent3 = new Student("Julian","Alvarez","spider@gmail.com");

        //save the student object
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        System.out.println("Saved Student. Generated id: "+tempStudent.getId());
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


