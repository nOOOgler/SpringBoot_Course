package com.codingshuttle.omkar.module1.services;

import com.codingshuttle.omkar.module1.Dto.EmployeeDto;
import com.codingshuttle.omkar.module1.controllers.Employee;
import com.codingshuttle.omkar.module1.entities.EmployeeEntity;
import com.codingshuttle.omkar.module1.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public Optional<EmployeeDto> getEmployee(Long id) {
//        Optional<EmployeeEntity> employeeEntity =  employeeRepository.findById(id);
//        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDto.class));

        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class));

    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.
                stream()
                .map(EmployeeEntity -> modelMapper.map(EmployeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);;   // only entity type can be stored in repository, hence converting
        EmployeeEntity savedEntity =  employeeRepository.save(toSaveEntity);
         return modelMapper.map(savedEntity, EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeData) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeData, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity updatedEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEntity, EmployeeDto.class);
    }

    public boolean isExistsByEmployeeId(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployee(Long employeeId) {
        boolean exists = isExistsByEmployeeId(employeeId);
        if(exists) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }

    public EmployeeDto updatePartialEmployee(Map<String, Object> updates, Long employeeId) {
        boolean exists = isExistsByEmployeeId(employeeId);
        if(!exists) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(EmployeeEntity.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employeeEntity, value);
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);
    }
}
