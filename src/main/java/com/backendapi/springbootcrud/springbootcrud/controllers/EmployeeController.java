package com.backendapi.springbootcrud.springbootcrud.controllers;

import com.backendapi.springbootcrud.springbootcrud.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * -> @RestController :-
 *   it is used to express request mapping, request input,exception handling and more.
 *
 * -> The @RestController annotation is a shorthand for @Controller and @ResponseBody,
 *    meaning all methods in the controller will return JSON/XML directly to the response body.
 *
 * */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    //    @GetMapping(path = "/getSecretMessage")
//    public String getEmployeeSecretMessage(){
//        return  "secret message : hike increased to shdjs";
//    }
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "raj", "raj@gmail.com", 27, LocalDate.of(2024, 1, 2), true);
    }

//    @GetMapping(path = "/employees")
    @GetMapping
    public String getAllEmployee(@RequestParam(required = false , name = "inputAge") Integer age,
                                 @RequestParam(required = false) String sortBy) {
        return "age is " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeInput){
        employeeInput.setId(120L);
        return employeeInput;
    }

    @PutMapping
    public String updateEmployeeById(){
        return "employee update through put";
    }
}
