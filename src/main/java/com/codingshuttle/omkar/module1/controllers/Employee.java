package com.codingshuttle.omkar.module1.controllers;

import com.codingshuttle.omkar.module1.Dto.EmployeeDto;
import com.codingshuttle.omkar.module1.entities.EmployeeEntity;
import com.codingshuttle.omkar.module1.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")                   //parent path, appended before every URL
public class Employee {

    private final EmployeeRepository employeeRepository;
    public Employee(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable(name = "employeeId") Long id){
//        return new EmployeeDto(id, "omkar", "omkar@gmail.com", 23, true, LocalDate.of(2025, 4,23));
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
//        return "Hi age" + age + " " + sortBy;
            return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(100L);
        return employeeRepository.save(inputEmployee);
    }
}
