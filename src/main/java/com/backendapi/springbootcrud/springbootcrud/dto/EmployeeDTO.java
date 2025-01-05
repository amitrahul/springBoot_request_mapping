package com.backendapi.springbootcrud.springbootcrud.dto;

import com.backendapi.springbootcrud.springbootcrud.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "name of employee can't be blank")
    @Size(min = 4, max = 12 , message = "Number of character in name field in range of : [4,12] ")
    private String name;

    @NotBlank(message = "email of an employee should not be the empty.")
    @Email(message = "email should be a valid email.")
    private String email;

    @NotNull(message = "age of an employee can't be blank.")
    @Max(value = 80, message = "age of employee should not be more than 80.")
    @Min(value = 18, message = "age of employee shouldn't be less than 18.")
    private Integer age;

    @NotBlank(message = "role of employee can't be blank.")
//    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can either be ADMIN or USER.")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "salary of an employee should not be null.")
    @Positive(message = "salary of an employee should be a positive number.")
    @Digits(integer = 5, fraction = 3, message = "salary must be in the rage of xxxxx.xxx")
    @DecimalMax(value = "10000.998")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "date of joining of field employee can't be future date.")
    private LocalDate dateOfJoining;

    // it will check this property must be true, if it is false then it will populate this message.`
    @AssertTrue(message = "employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
