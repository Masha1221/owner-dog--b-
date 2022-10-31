package com.example.demo.repositories;

import com.example.demo.dtos.DepartmentDTO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsPaginationRepository extends PagingAndSortingRepository<DepartmentDTO, Integer> {
}
