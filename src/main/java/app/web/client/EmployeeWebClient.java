package app.web.client;

import app.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeWebClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public void getEmployee() {
        Mono<Employee> employeeMono = client.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);
        employeeMono.subscribe(System.out::println);
    }

    public void getEmployees() {
        Flux<Employee> employees = client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);
        employees.subscribe(System.out::println);
    }
}
