package com.app.EmployeeApp.controller;

import com.app.EmployeeApp.model.Employee;
import com.app.EmployeeApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired //Creating Object
    EmployeeRepository employeeRepository;
    @PostMapping("/employee")
    public String createNewEmployee(@RequestBody Employee employee){ //Posting data
    employeeRepository.save(employee);
    return "Employee is add to database";
    }
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee>  empList = new ArrayList<>();
        employeeRepository.findAll().forEach(empList::add);
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }
    @GetMapping("/employee/{emp_id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable int emp_id){
        Optional<Employee> emp = employeeRepository.findById(emp_id);
        if(emp.isPresent()){
            return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
        }else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/employee/{emp_id}")
    public String updateEmployee(@PathVariable int emp_id,@RequestBody Employee employee){
        Optional<Employee> emp = employeeRepository.findById(emp_id);
        if(emp.isPresent()){
            Employee existEmployee = emp.get();
            existEmployee.setEmp_age(employee.getEmp_age());
            existEmployee.setEmp_name(employee.getEmp_name());
            existEmployee.setEmp_city(employee.getEmp_city());
            existEmployee.setEmp_salary(employee.getEmp_salary());
            employeeRepository.save(existEmployee);
            return "Employee Data is Updated"+emp_id;
        }else{
            return "Employee Id is not valid "+emp_id;
        }
    }
    @DeleteMapping("/employee/{emp_id}")
    public String deleteEmployeeById(@PathVariable int emp_id){
        employeeRepository.deleteById(emp_id);
        return emp_id + " is deleted";
    }
    @DeleteMapping("/employee")
    public String deleteAllEmployee(){
        employeeRepository.deleteAll();
        return "All Employee Details deleted successfully";
    }

}
