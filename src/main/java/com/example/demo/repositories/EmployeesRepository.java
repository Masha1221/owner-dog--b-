package com.example.demo.repositories;

import com.example.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findEmployeeEntityByIdAndDepartmentEntityId(Integer empID, Integer dpID);
}
