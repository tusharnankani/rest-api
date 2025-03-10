package com.springboot.rest_api.controller;

import com.springboot.rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("students")
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
    public Student studentWithManyPathVariables(@PathVariable int id, @PathVariable String first, @PathVariable String last) {
        return new Student(id, first, last);
    }
}
