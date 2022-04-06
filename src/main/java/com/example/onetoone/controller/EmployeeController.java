package com.example.onetoone.controller;

import com.example.onetoone.entity.Employee;
import com.example.onetoone.repository.AddressRepository;
import com.example.onetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("getallEmployee")
    public  List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @GetMapping("getById/{empId}")
    public Optional<Employee> getEmployeeByIs(@PathVariable Long empId){
        return  employeeRepository.findById(empId);

    }
    @PostMapping("save")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return ResponseEntity.ok("Data saved");
    }
@DeleteMapping("deleteById/{empId}")
    public  void  deleteById(@PathVariable Long empId ){
        employeeRepository.deleteById(empId);
}
@PutMapping("editById/{empId}")
public Employee update(@PathVariable Long empId,@RequestBody Employee employee){
Employee employee1 =employeeRepository.findById(empId).orElse(null);
employee1.setEmpName(employee.getEmpName());
employee1.setEmpAge(employee.getEmpAge());
employee1.setAddress(employee.getAddress());
employee1.setEmpId(employee.getEmpId());
return employeeRepository.save(employee1);
}

    /*@PostMapping("save")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> employees){
        employeeRepository.saveAll(employees);
        return ResponseEntity.ok("Data saved");
    }


    }
    @GetMapping("getById")
    public  Employee getEmployeeByIs(@PathVariable Long empId){
        return  employeeRepository.getById(empId);

    }
*/
}
