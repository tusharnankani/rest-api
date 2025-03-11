package com.springboot.rest_api.controller;

import com.springboot.rest_api.bean.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "Tushar", "Nankani");
        return student;

        // This returns a Bean, which converts into JSON
        /* {
              "id": 1,
              "firstName": "Tushar",
              "lastName": "Nankani"
            }
        * */
    }

    /*
    * Returns a list of Bean -- Array of Objects
    * [
          {
            "id": 1,
            "firstName": "Tushar",
            "lastName": "Nankani"
          },
          {
            "id": 1,
            "firstName": "Tushar",
            "lastName": "Nankani"
          },
          {
            "id": 1,
            "firstName": "Tushar",
            "lastName": "Nankani"
          }
    ]
    * */
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Tushar", "Nankani"));
        students.add(new Student(1, "Tushar", "Nankani"));
        students.add(new Student(1, "Tushar", "Nankani"));
        return students;
    }

    // URI Template variable
/* --> One way of implementation "id", "id"
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable int id) {
        return new Student(id, "Tushar", "Nankani");
    }
*/
/* --> Second way of implementation
       Defining PathVariable
*/
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "Tushar", "Nankani");
    }

    /*
    * Handling multiple Path Variables
    * */
    @GetMapping("/student/{id}/{first}/{last}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable String first, @PathVariable String last) {
        return new Student(id, first, last);
    }




    /*
    * Spring boot API with RequestParam
    * */

    // localhost:8080/student/query?id=1
    @GetMapping("/student/query")
    public Student studentRequestVariable(@RequestParam int id) {
        return new Student(id, "Tushar", "Nankani");
    }

    // localhost:8080/student/query1?id=1&firstName=Tushar&lastName=Nankani
    @GetMapping("/student/query1")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    /**
     * Difference between PathVariable and RequestParam
     *
     * 1. While @RequestParams extract values from the query string, @PathVariables extract values from the URI path:
     * 2. @RequestParam is encoded. @PathVariable is extracting values from the URI path, it’s not encoded.
     *
     * http://localhost:8080/spring-mvc-basics/foos/ab+c
     * ----
     * ID: ab+c
     *
     * http://localhost:8080/spring-mvc-basics/foos?id=ab+c
     * ----
     * ID: ab c
     *
     * 3. Both @RequestParam and @PathVariable can be optional.
     * */

    /**
     * http://localhost:8080/stduent/optional/abc
     * ----
     * ID: abc
     *
     * http://localhost:8080/stduent/optional
     * ----
     * ID: null
     * */
    @GetMapping("/students/optional/{id}")
    public String getStudentByOptionalPathVariable(@PathVariable(required = false) String id){
        return "ID: " + id;
    }


    /**
     * http://localhost:8080/student/query/optional?id=abc
     * ----
     * ID: abc
     *
     * http://localhost:8080/student/query/optional
     * ----
     * ID: null
     * */
    @GetMapping("/student/query/optional")
    public String getStudentByOptional(@RequestParam(required = false) String id) {
        return "ID: " + id;
    }




}
