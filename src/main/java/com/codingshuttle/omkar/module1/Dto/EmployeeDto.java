package com.codingshuttle.omkar.module1.Dto;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private boolean isActive;
    private LocalDate doj;

    public EmployeeDto(){

    }

    public EmployeeDto(Long id, String name, String email, Integer age, boolean isActive, LocalDate doj) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.doj = doj;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
}
