package com.infosys.EMP_SERVICE.controller;

import com.infosys.EMP_SERVICE.model.Employee;
import com.infosys.EMP_SERVICE.model.EmployeeResponseDto;
import com.infosys.EMP_SERVICE.model.DepartmentDto;
import com.infosys.EMP_SERVICE.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/add")
    public Mono<ResponseEntity<EmployeeResponseDto>> addEmployee(@RequestBody Employee employee) {
        System.out.println("Received employee: " + employee);

        return webClientBuilder.build().get()
                .uri("http://localhost:8081/departments/" + employee.getDeptId())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .map(departmentDTO -> {
                    EmployeeResponseDto responseDTO = new EmployeeResponseDto();

                    responseDTO.setEmpId(employee.getEmpId());
                    responseDTO.setName(employee.getName());
                    responseDTO.setSalary(employee.getSalary());
                    responseDTO.setDeptId(employee.getDeptId());

                    responseDTO.setDeptName(departmentDTO.getDepartmentName());
                    responseDTO.setManagerId(departmentDTO.getManagerId());

                    employeeRepo.save(employee);

                    return ResponseEntity.ok(responseDTO);
                })
                .onErrorResume(e -> {
                    e.printStackTrace();
                    return Mono.just(ResponseEntity.internalServerError().build());
                });
    }

    @GetMapping("/all")
    public Mono<ResponseEntity<List<EmployeeResponseDto>>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();

        List<Mono<EmployeeResponseDto>> responseMonos = employees.stream().map(emp ->
                webClientBuilder.build().get()
                        .uri("http://localhost:8081/departments/" + emp.getDeptId())
                        .retrieve()
                        .bodyToMono(DepartmentDto.class)
                        .map(dept -> {
                            EmployeeResponseDto dto = new EmployeeResponseDto();
                            dto.setEmpId(emp.getEmpId());
                            dto.setName(emp.getName());
                            dto.setSalary(emp.getSalary());
                            dto.setDeptId(emp.getDeptId());
                            dto.setDeptName(dept.getDepartmentName());
                            dto.setManagerId(dept.getManagerId());
                            return dto;
                        })
        ).toList();

        return Mono.zip(responseMonos, array ->
                ResponseEntity.ok(
                        Arrays.stream(array)
                                .map(obj -> (EmployeeResponseDto) obj)
                                .toList()
                )
        );
    }

}
