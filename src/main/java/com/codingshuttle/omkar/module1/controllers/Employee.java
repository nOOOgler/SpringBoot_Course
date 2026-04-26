package com.codingshuttle.omkar.module1.controllers;

import com.codingshuttle.omkar.module1.Dto.EmployeeDto;
import com.codingshuttle.omkar.module1.entities.EmployeeEntity;
import com.codingshuttle.omkar.module1.repositories.EmployeeRepository;
import com.codingshuttle.omkar.module1.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")                   //parent path, appended before every URL
public class Employee {

    private final EmployeeRepository employeeRepository;               //not good practice, will use employee service
    private final EmployeeService employeeService;
    public Employee(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name = "employeeId") Long id){
//        return new EmployeeDto(id, "omkar", "omkar@gmail.com", 23, true, LocalDate.of(2025, 4,23));
       // return employeeRepository.findById(id).orElse(null);         not good practice
//        return employeeService.getEmployee(id);                        //good practice using service layer
        Optional<EmployeeDto> employeeDto = employeeService.getEmployee(id);
        return employeeDto
                .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) Integer age,
                                                      @RequestParam(required = false) String sortBy){
//        return "Hi age" + age + " " + sortBy;
        //    return employeeRepository.findAll();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto inputEmployee){
//        inputEmployee.setId(100L);
  //      return employeeRepository.save(inputEmployee);
        EmployeeDto savedEmployee = employeeService.createNewEmployee((inputEmployee));
        return new ResponseEntity(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto employeeData, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeData));
    }

    @DeleteMapping(path ="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId){
       boolean gotDeleted = employeeService.deleteEmployee(employeeId);
       if(gotDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }

    @PatchMapping(path ="/{employeeId}")
    public ResponseEntity<EmployeeDto> updatePartialEmployee(@RequestBody Map<String, Object> updates,
                                                @PathVariable Long employeeId){
        EmployeeDto employeeDto = employeeService.updatePartialEmployee(updates, employeeId);
        if(employeeDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDto);
    }
}
