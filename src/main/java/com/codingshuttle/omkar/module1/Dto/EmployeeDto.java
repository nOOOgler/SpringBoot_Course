package com.codingshuttle.omkar.module1.Dto;

import com.codingshuttle.omkar.module1.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    //@NotNull(message = "Required field for employee: name")
    @NotBlank(message = "Required field for employee: name")     /// preferred for strings, checks null and trim length too
    @Size(min = 3, max = 10, message = "Numer of characters in name should be between 3 - 10 ")
    private String name;

    @NotBlank(message = "email field should not be empty")
    @Email(message = "Email should be valid mail")
    private String email;

    @Max(value = 80, message = "age cannot be greater than 80")
    @Min(value = 18, message = "age cannot be less than 18")
    private Integer age;

    @AssertTrue(message = "employee should be active")
    private boolean isActive;

    @Past(message = "DateOfJoining field in Employee cannot be in future")
    private LocalDate doj;

    @NotBlank(message = "role field should cannot be blank")
//    @Pattern(regexp = "^(USER|ADMIN)$", message = "role field should either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @Positive(message = "salary should be positive")
    @Digits(integer = 6, fraction = 2, message = "the salary can be in form of XXXXXX.YY")
    private Integer salary;



}
