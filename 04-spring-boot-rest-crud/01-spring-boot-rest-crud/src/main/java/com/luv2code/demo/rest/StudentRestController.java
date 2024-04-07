package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Bhavesh","Gangajaliya"));
        theStudents.add(new Student("Neha","Gangajaliya"));
        theStudents.add(new Student("Noopur","Gangajaliya"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable String studentId) {

        if(studentId.matches(".*[a-zA-Z]+.*")) {
            throw new StudentNotFoundException("Please enter a valid student id. You entered: " + studentId);
        }

        if((Integer.parseInt(studentId) >= theStudents.size()) || (Integer.parseInt(studentId) < 0)) {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }

        return theStudents.get(Integer.parseInt(studentId));
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(exc.getMessage());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setMessage(exc.getMessage());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }

}
