package com.ozalp.AkgunTest.business.abstracts;

import com.ozalp.AkgunTest.common.results.DataResult;
import com.ozalp.AkgunTest.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.entities.concretes.Employee;

public interface EmployeeService extends BaseService<Employee> {

    DataResult<EmployeeResponse> create(CreateEmployeeRequest request);
}
