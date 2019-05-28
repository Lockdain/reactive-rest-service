package app.repository;

import app.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Test
    public void findEmployeeById() {
        assertEquals(new Employee(2, "Mike"), employeeRepository.findEmployeeById(2));
    }

    @Test
    public void findEmployeeByName() {
        assertEquals(new Employee(7, "Carl"), employeeRepository.findEmployeeByName("Carl"));
    }
}