package com.projects.springbootwebtutorial.controllers;

import com.projects.springbootwebtutorial.dto.EmployeeDTO;
import com.projects.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") String id) {
        return employeeService.getEmployeeById(Long.valueOf(id));
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@PathVariable(name = "employeeId") String id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeById(Long.valueOf(id), employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable(name = "employeeId") String id) {
        return employeeService.deleteEmployeeById(Long.valueOf(id));
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable String employeeId) {
        return employeeService.updatePartialEmployeeById(Long.valueOf(employeeId), updates);
    }
}
