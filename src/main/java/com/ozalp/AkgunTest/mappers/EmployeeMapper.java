package com.ozalp.AkgunTest.mappers;

import com.ozalp.AkgunTest.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.entities.concretes.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(CreateEmployeeRequest request);
}
