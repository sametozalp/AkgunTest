package com.ozalp.AkgunTest.controller.api;

import com.ozalp.AkgunTest.dtos.requests.CreateEmployeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @PostMapping("/createEmployee")
    ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return null;
    }
}
