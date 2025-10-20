package com.ozalp.AkgunTest.business.mappers;

import com.ozalp.AkgunTest.business.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.business.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.entities.concretes.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(CreateEmployeeRequest request);

    EmployeeResponse toResponse(Employee employee);
}
