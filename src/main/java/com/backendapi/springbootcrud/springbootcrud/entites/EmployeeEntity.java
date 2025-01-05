package com.backendapi.springbootcrud.springbootcrud.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*
*  @Entity annotation :-
*   -> It will tell the spring JPA or (Hibernate) that this is the java class
*       that need tp convert the table inside database.
*
* ==================================>   <==================================> ==================================>
* The @Entity annotation in Spring and Java Persistence API (JPA) is used to mark
* a class as a persistent entity, meaning it represents a table in a relational database.
* This is a fundamental part of the ORM (Object-Relational Mapping) paradigm,
* where Java objects are mapped to database tables.
-> Key Points of @Entity:
• Class-Level Annotation
• Primary Key
• Automatic Table Mapping
*
*
*
* * ==================================>   <==================================> ==================================>
                                     JPARepository Interface

* The JPARepository interface in Spring Data JPA provides a set of CRUD (Create, Read, Update, Delete)
*  operations and query methods for interacting with the database.
Key Points of CrudRepository :
• Generic Interface
• Predefined Methods
• Custom Queries

 * */
@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
    private String role;
    private Double salary;

}
