package com.example.demo.services_Impl;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.repositories.DepartmentsRepository;
import com.example.demo.repositories.EmployeesRepository;
import com.example.demo.services.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

    private final ModelMapper modelMapper;
    private final EmployeesRepository employeesRepository;
    private final DepartmentsRepository departmentsRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Integer dpID) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDTO.getName());
        DepartmentEntity departmentEntity = departmentsRepository.findById(dpID).orElse(null);
        if (departmentEntity == null) {
            throw new ApiRequestException("Department with this ID is not exist.");
        }
        employeeEntity.setDepartmentEntity(departmentEntity);
        employeesRepository.save(employeeEntity);
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(Integer empID, Integer dpID) {
        EmployeeEntity employeeEntity = employeesRepository.findEmployeeEntityByIdAndDepartmentEntityId(empID, dpID);
        if (employeeEntity == null) {
            throw new ApiRequestException("These IDs are not exist.");
        }
        employeesRepository.deleteById(empID);
    }

    @Override
    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Integer empID) {
        EmployeeEntity employeeEntity = employeesRepository.findById(empID).orElseThrow(null);
        if (employeeEntity == null) {
            throw new ApiRequestException("Employee with this ID is not exist.");
        }
        employeeEntity.setName(employeeDTO.getName());
        employeesRepository.save(employeeEntity);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer empID) {
        EmployeeEntity employeeEntity = employeesRepository.findById(empID).orElseThrow(null);
        if (employeeEntity == null) {
            throw new ApiRequestException("Employee with this ID is not exist.");
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName((employeeEntity.getName()));
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeesRepository.findAll().stream().map(entity -> modelMapper
                        .map(entity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}