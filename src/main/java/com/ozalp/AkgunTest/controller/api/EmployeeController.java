package com.ozalp.AkgunTest.controller.api;

import com.ozalp.AkgunTest.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.business.dtos.requests.CreateEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/createEmployee")
    ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.create(request));
    }
}
