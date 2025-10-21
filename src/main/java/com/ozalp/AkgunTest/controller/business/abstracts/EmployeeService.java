package com.ozalp.AkgunTest.controller.business.abstracts;

import com.ozalp.AkgunTest.common.results.DataResult;
import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.model.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {

    DataResult<EmployeeResponse> create(CreateEmployeeRequest request);

    DataResult<List<EmployeeResponse>> getAll();
}
