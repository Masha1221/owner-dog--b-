package com.example.demo.services;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.entities.EmployeeEntity;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.repositories.DepartmentsRepository;
import com.example.demo.repositories.EmployeesRepository;
import com.example.demo.responses.EmployeesResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        employeeEntity.setActive(employeeDTO.isActive());

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
    public List<EmployeeDTO> getAllEmployee() {
        return employeesRepository.findAll().stream().map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeesResponse findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EmployeeEntity> employeesEntity = employeesRepository.findAll(pageable);
        List<EmployeeEntity> listOfEmployees = employeesEntity.getContent();
        List<EmployeeDTO> content = listOfEmployees.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());

        EmployeesResponse employeesResponse = new EmployeesResponse();
        employeesResponse.setContent(content);
        employeesResponse.setPageNo(employeesEntity.getNumber());
        employeesResponse.setPageSize(employeesEntity.getSize());
        employeesResponse.setTotalElements(employeesEntity.getTotalElements());
        employeesResponse.setTotalPages(employeesEntity.getTotalPages());
        employeesResponse.setLast(employeesEntity.isLast());
        return employeesResponse;
    }
}