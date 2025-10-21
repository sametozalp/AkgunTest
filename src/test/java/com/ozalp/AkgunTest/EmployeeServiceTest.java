package com.ozalp.AkgunTest;

import com.ozalp.AkgunTest.controller.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.common.results.DataResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeService;

    @Test
    public void createEmployee() {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setName("samet");
        request.setSurname("ozalp");
        request.setPhoneNumber("+905443596808");
        request.setSocialSecurityNumber("12345678910");
        DataResult<EmployeeResponse> response = employeeService.create(request);
        System.out.println(response);

    }
}
