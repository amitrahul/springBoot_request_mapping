package com.backendapi.springbootcrud.springbootcrud.controllers;

import com.backendapi.springbootcrud.springbootcrud.dto.EmployeeDTO;
import com.backendapi.springbootcrud.springbootcrud.entites.EmployeeEntity;
import com.backendapi.springbootcrud.springbootcrud.exception.ResourceNotFoundException;
import com.backendapi.springbootcrud.springbootcrud.repositories.EmployeeRepository;
import com.backendapi.springbootcrud.springbootcrud.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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

//    private final EmployeeRepository employeeRepository ;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    //    @GetMapping(path = "/getSecretMessage")
//    public String getEmployeeSecretMessage(){
//        return  "secret message : hike increased to shdjs";
//    }
    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
//        return new EmployeeDTO(id, "raj", "raj@gmail.com", 27, LocalDate.of(2024, 1, 2), true);
//        return employeeRepository.findById(id).orElse(null);
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
//                .orElse(ResponseEntity.notFound().build());
                .orElseThrow(() -> new ResourceNotFoundException("employee not found with id " + id));
    }


//    @GetMapping(path = "/employees")
    @GetMapping
    public ResponseEntity<List<EmployeeDTO> > getAllEmployee(@RequestParam(required = false , name = "inputAge") Integer age,
                                               @RequestParam(required = false) String sortBy) {
//        return "age is " + age + " " + sortBy;
//        return employeeRepository.findAll();
//        return employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }


    // @Valid annotation, used to validate the controller, is EmployeeDTO taking correct or mandatory i/p from user.
    @PostMapping
    public ResponseEntity<EmployeeDTO>  createNewEmployee(@RequestBody @Valid EmployeeDTO employeeInput){
//        employeeInput.setId(120L);
//        return employeeInput;
//        return employeeRepository.save(employeeInput);
//        return employeeService.createNewEmployee(employeeInput);
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(employeeInput);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDto , @PathVariable Long employeeId){
//        return employeeService.updateEmployeeById(employeeId , employeeDto);
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId , employeeDto));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
//       return employeeService.deleteEmployeeId(employeeId);
        boolean gotDeletedUser = employeeService.deleteEmployeeId(employeeId);
        if(gotDeletedUser)
            return ResponseEntity.ok(gotDeletedUser);
        return ResponseEntity.notFound().build();
    }


    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
//        return employeeService.updatePartialEmployeeById(employeeId,updates);

       EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId,updates);
       if(employeeDTO == null)
           return ResponseEntity.notFound().build();
       return ResponseEntity.ok(employeeDTO);
    }

}

