package com.ozalp.AkgunTest.business.abstracts;

import com.ozalp.AkgunTest.common.results.DataResult;
import com.ozalp.AkgunTest.business.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.business.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {

    DataResult<EmployeeResponse> create(CreateEmployeeRequest request);

    DataResult<List<EmployeeResponse>> getAll();
}
