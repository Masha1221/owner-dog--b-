package com.example.demo.controllers;

import com.example.demo.constants.AppConstants;
import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.responses.DepartmentsResponse;
import com.example.demo.services.DepartmentsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class DepartmentsController {

    private final DepartmentsServiceImpl departmentsService;

    @GetMapping("/departments/{dpID}")
    public ResponseEntity<HttpStatus> getDepartmentById(@PathVariable Integer dpID) {
        DepartmentDTO departmentDTO = departmentsService.getDepartmentById(dpID);
        log.info("Get department with id {}. Department is {}.", dpID, departmentDTO.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/departments")
    public ResponseEntity<HttpStatus> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentsService.createDepartment(departmentDTO);
        log.info("Department {} has been created.", departmentDTO.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{dpID}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Integer dpID) {
        departmentsService.deleteDepartmentById(dpID);
        log.info("Department with id {} has been removed.", dpID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/departments/{dpID}")
    public ResponseEntity<HttpStatus> updateDepartmentById(@RequestBody DepartmentDTO departmentDTO,
                                                           @PathVariable Integer dpID) {
        departmentsService.updateDepartmentById(departmentDTO, dpID);
        log.info("Department with id {} has been updated. The department is {}.", dpID, departmentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/departments/pages")
    public DepartmentsResponse getAllDepartmnets(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize) {
        return departmentsService.findPaginated(pageNo, pageSize);
    }
}