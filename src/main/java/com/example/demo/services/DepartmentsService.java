package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentsService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    void deleteDepartmentById(Integer dpID);

    DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Integer dpID);

    DepartmentDTO getDepartmentById(Integer dpID);
     List<DepartmentDTO> getAllDepartments();

   List<DepartmentDTO> findPaginated(int pageNo, int pageSize);

}
