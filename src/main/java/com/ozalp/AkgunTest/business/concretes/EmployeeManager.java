package com.ozalp.AkgunTest.business.concretes;

import com.ozalp.AkgunTest.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.business.rules.EmployeeRules;
import com.ozalp.AkgunTest.common.Messages;
import com.ozalp.AkgunTest.common.results.DataResult;
import com.ozalp.AkgunTest.common.results.SuccessDataResult;
import com.ozalp.AkgunTest.dataAccess.EmployeeRepository;
import com.ozalp.AkgunTest.business.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.business.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.entities.concretes.Employee;
import com.ozalp.AkgunTest.exceptions.errors.EmployeeNotFoundException;
import com.ozalp.AkgunTest.business.mappers.EmployeeMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final EmployeeRules employeeRules;

    @Transactional
    @Override
    public Boolean delete(UUID uuid) {
        Employee employee = getById(uuid);
        employee.markAsDeleted();
        repository.save(employee);
        return true;
    }

    @Override
    public Employee getById(UUID uuid) {
        return repository.findById(uuid)
                .orElseThrow(() -> new EmployeeNotFoundException(Messages.EmployeeMessages.EMPLOYEE_NOT_FOUND));
    }

    @Override
    public DataResult<EmployeeResponse> create(CreateEmployeeRequest request) {
        Employee employee = mapper.toEntity(request);
        employeeRules.checkPhoneNumber(employee);
        employeeRules.checkSocialSecurityNumber(employee);
        return new SuccessDataResult<>(mapper.toResponse(repository.save(employee)));
    }
}
