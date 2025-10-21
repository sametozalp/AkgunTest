package com.ozalp.AkgunTest.common.employeeDataService;

import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;

import java.util.List;

public interface EmployeeDataService {
    List<EmployeeResponse> getData();
}
