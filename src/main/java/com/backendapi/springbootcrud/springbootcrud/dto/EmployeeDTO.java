package com.backendapi.springbootcrud.springbootcrud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

}
