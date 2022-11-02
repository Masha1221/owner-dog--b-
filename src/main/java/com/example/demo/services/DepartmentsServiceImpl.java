package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.repositories.DepartmentsRepository;
import com.example.demo.responses.DepartmentsResponse;
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
    public DepartmentsResponse findPaginated(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DepartmentEntity> departmentsEntity = departmentsRepository.findAll(pageable);
        List<DepartmentEntity> listOfDepartments = departmentsEntity.getContent();
        List<DepartmentDTO> content = listOfDepartments
                .stream()
                .map(departmentEntity -> modelMapper
                        .map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());

        DepartmentsResponse departmentsResponse = new DepartmentsResponse();
        departmentsResponse.setContentDep(content);
        departmentsResponse.setPageNoDep(departmentsEntity.getNumber());
        departmentsResponse.setPageSizeDep(departmentsEntity.getSize());
        departmentsResponse.setTotalElementsDep(departmentsEntity.getTotalElements());
        departmentsResponse.setTotalPagesDep(departmentsEntity.getTotalPages());
        departmentsResponse.setLastDep(departmentsEntity.isLast());
        return departmentsResponse;
    }


}
