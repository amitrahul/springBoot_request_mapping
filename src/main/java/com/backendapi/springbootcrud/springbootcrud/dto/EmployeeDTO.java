package com.backendapi.springbootcrud.springbootcrud.dto;

import java.time.LocalDate;

/*
* DTO -> it stands for data transfer object.
*    it stays b/w presentation and service layer.
*
* ===> it is a POJO (Plain Old Java Object) Class.
* -> POJO stands for Plain Old Java Object. It is a term used to describe a Java class that follows
*     simple conventions and does not depend on any specific frameworks or libraries.
*
* -> A POJO typically contains private fields with corresponding getter and setter methods,
*     and it may also include additional methods for behaviour.
*
* -> POJOs are commonly used to encapsulate data and represent entities in an application.
*    They are often used in frameworks like Java Persistence API (JPA) for mapping database
*    records to Java objects, or in serialization/deserialization processes where objects
*    are converted to and from formats like JSON or XML.
*
*
* =====> Working of POJO Class:
   ->An object class in Java is the POJO class. It includes business logic. In a Model View Controller architecture,
    after viewing, the controller would communicate with the business logic, which would then get in
    touch with the Java POJO class to retrieve the data. The phrase “business logic” describes the
    comprehensive collection of guidelines that specify how data will be handled or stored inside a business
    or application domain.

*========> Use of POJO Class in Java:
  ->The POJO class was developed so that Java programs may utilize the objects.
    The main benefit of the POJO class is that it eliminates the need to repeatedly generate
    objects in other Java programs. Simply said, we may use the get() and set() methods to access the objects.
*
 * */
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    public EmployeeDTO() {

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
