package app.repository;

import app.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeRepository {

    private static final HashMap<Integer, Employee> employeeMap;

    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1, new Employee(1, "John"));
        employeeMap.put(2, new Employee(2, "Mike"));
        employeeMap.put(3, new Employee(3, "Viky"));
        employeeMap.put(4, new Employee(4, "Liloo"));
        employeeMap.put(5, new Employee(5, "Warren"));
        employeeMap.put(6, new Employee(6, "Julie"));
        employeeMap.put(7, new Employee(7, "Carl"));
    }

    EmployeeRepository() {
    }

    public Employee findEmployeeById(int id) {
        return employeeMap.get(id);
    }

    Employee findEmployeeByName(String name) {
        for (Map.Entry<Integer, Employee> integerEmployeeEntry : employeeMap.entrySet()) {
            Map.Entry pair = (Map.Entry) integerEmployeeEntry;
            Employee employee = (Employee) pair.getValue();
            if (name.equalsIgnoreCase(employee.getName())) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeMap.entrySet()
                .forEach(e -> employees.add(e.getValue()));
        return employees;
    }

    public Employee updateEmployee(Employee employee) {
       return employeeMap.entrySet().stream()
                .filter(e -> e.getValue().equals(employee))
                .findFirst()
                .orElse(null)
                .getValue();
    }
}
