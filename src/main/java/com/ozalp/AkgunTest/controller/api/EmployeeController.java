package com.ozalp.AkgunTest.controller.api;

import com.ozalp.AkgunTest.controller.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/createEmployee")
    ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.create(request));
    }

    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }
}
