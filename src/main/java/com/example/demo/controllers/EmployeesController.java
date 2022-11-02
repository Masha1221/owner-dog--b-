package com.example.demo.controllers;

import com.example.demo.constants.AppConstants;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.responses.EmployeesResponse;
import com.example.demo.services.EmployeesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmployeesController {

    private final EmployeesServiceImpl employeesService;

    @GetMapping("/employees/{empID}")
    public ResponseEntity<HttpStatus> getEmployeeById(@PathVariable Integer empID) {
        EmployeeDTO employeeDTO = employeesService.getEmployeeById(empID);
        log.info("Get employee with id {}. Employee is {}. ", empID, employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/departments/{dpId}/employees")
    public ResponseEntity<HttpStatus> createEmployee(@PathVariable(value = "dpId") Integer id,
                                                     @RequestBody EmployeeDTO employeeDTO) {
        employeesService.createEmployee(employeeDTO, id);
        log.info("Employee for department with id {} has been created. Employee is {}.", id, employeeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("employees/{empId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeDTO employeeDTO) {
        employeesService.updateEmployeeById(employeeDTO, empId);
        log.info("Employee with id {} has been updated. The new employee is {}.", empId, employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/departments/{dpId}/employees/{empId}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Integer dpId, @PathVariable Integer empId) {
        employeesService.deleteEmployee(empId, dpId);
        log.info("Employee with id {} for department with id {} has been deleted.", empId, dpId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/employees/pages")
    public EmployeesResponse getAllAmployess(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize) {
        return employeesService.findPaginated(pageNo, pageSize);
    }
}