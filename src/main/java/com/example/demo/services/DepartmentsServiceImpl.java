package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.repositories.DepartmentsPaginationRepository;
import com.example.demo.repositories.DepartmentsRepository;
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
public class DepartmentsServiceImpl implements DepartmentsService {

    private final ModelMapper modelMapper;
    private final DepartmentsRepository departmentsRepository;

    private final DepartmentsPaginationRepository departmentsPaginationRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity existingDepartment = departmentsRepository.findById(departmentDTO.getId())
                .orElse(null);
        if (existingDepartment == null) {
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setName(departmentDTO.getName());
            departmentsRepository.save(departmentEntity);
            return departmentDTO;
        } else {
            throw new ApiRequestException("Department with this id already exists!!");
        }
    }

    @Override
    public void deleteDepartmentById(Integer dpID) {
        DepartmentEntity departmentEntity = departmentsRepository.findById(dpID).orElse(null);
        if (departmentEntity == null) {
            throw new ApiRequestException("Department with this ID are not exist.");
        }
        departmentsRepository.delete(departmentEntity);
    }

    @Override
    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Integer dpID) {
        DepartmentEntity departmentEntity = departmentsRepository.findById(dpID).orElse(null);
        if (departmentEntity == null) {
            throw new ApiRequestException("Department with this ID are not exist.");
        }
        departmentEntity.setName(departmentDTO.getName());
        departmentsRepository.save(departmentEntity);
        return departmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer dpID) {
        DepartmentEntity departmentEntity = departmentsRepository.findById(dpID).orElse(null);
        if (departmentEntity == null) {
            throw new ApiRequestException("Department with this ID is not exist!!");
        }
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(departmentEntity.getName());
        return departmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentsRepository.findAll().stream().map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentDTO> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DepartmentDTO> pagedRequest = departmentsPaginationRepository.findAll(pageable);
        return pagedRequest.stream().map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
}
