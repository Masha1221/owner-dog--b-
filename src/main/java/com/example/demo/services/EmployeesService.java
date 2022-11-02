package com.example.demo.services;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.responses.EmployeesResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeesService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Integer dpId);

    void deleteEmployee(Integer empID, Integer dpID);

    EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Integer empID);

    EmployeeDTO getEmployeeById(Integer empID);

    EmployeesResponse findPaginated(int pageNo, int pageSize);

    List<EmployeeDTO> getAllEmployee();

}
