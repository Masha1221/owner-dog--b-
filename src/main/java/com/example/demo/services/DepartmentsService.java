package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.responses.DepartmentsResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentsService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    void deleteDepartmentById(Integer dpID);

    DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Integer dpID);

    DepartmentDTO getDepartmentById(Integer dpID);

    List<DepartmentDTO> getAllDepartments();

    DepartmentsResponse findPaginated(int pageNo, int pageSize);
}
