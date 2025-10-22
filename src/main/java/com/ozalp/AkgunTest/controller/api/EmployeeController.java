package com.ozalp.AkgunTest.controller.api;

import com.ozalp.AkgunTest.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //    @PostMapping("/createEmployee")
//    ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
//        return ResponseEntity.ok(employeeService.create(request));
//    }

    @PostMapping("/createEmployee")
    String createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        return "AddEmployeeScreen";
    }

    @GetMapping("/getAll")
    String getAll(Model model) {
        model.addAttribute("list", employeeService.getAll());
        return "EmployeeList";
    }
}
