package com.ozalp.AkgunTest.model.mappers;

import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.model.entities.concretes.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(CreateEmployeeRequest request);

    EmployeeResponse toResponse(Employee employee);
}
