package app.controller;

import app.entity.Employee;
import app.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Data
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable String id) {
        return Mono.just(employeeRepository.findEmployeeById(Integer.valueOf(id)));
    }

    @GetMapping
    private Flux<List<Employee>> getAllEmployees() {
        return Flux.just(employeeRepository.findAllEmployees());
    }

    @PostMapping("/update")
    private Mono<Employee> updateEmployee(@RequestBody Employee employee) {
        return Mono.just(employeeRepository.updateEmployee(employee));
    }


}
