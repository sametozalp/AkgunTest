package com.ozalp.AkgunTest.controller.business.concretes;

import com.google.gson.Gson;
import com.ozalp.AkgunTest.controller.business.abstracts.EmployeeService;
import com.ozalp.AkgunTest.model.dtos.requests.CreateEmployeeRequest;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.model.mappers.EmployeeMapper;
import com.ozalp.AkgunTest.controller.business.rules.EmployeeRules;
import com.ozalp.AkgunTest.common.Constant;
import com.ozalp.AkgunTest.common.Messages;
import com.ozalp.AkgunTest.common.results.DataResult;
import com.ozalp.AkgunTest.common.results.SuccessDataResult;
import com.ozalp.AkgunTest.controller.dataAccess.EmployeeRepository;
import com.ozalp.AkgunTest.model.entities.concretes.Employee;
import com.ozalp.AkgunTest.common.exceptions.errors.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final EmployeeRules employeeRules;
    private final UnifiedJedis unifiedJedis;
    private final Gson gson;

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

    // burası daha verimli olmalı
    @Override
    public DataResult<List<EmployeeResponse>> getAll() {

        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        String redisJson = unifiedJedis.get(Constant.EMPLOYEES);

        if (redisJson != null) { // bu ifi yazmak pek yönetilebilir gelmedi bana ama şimdilik böyle dursun
            EmployeeResponse[] array = gson.fromJson(redisJson, EmployeeResponse[].class); // liste verince olmuyor ama dizilerde çalışıyormuş
            employeeResponses = Arrays.asList(array);
            return new SuccessDataResult<>(employeeResponses);
        }

        // çok veride pagination kullanılabilir
        List<Employee> employees = repository.findAll();
        // for yerine streams kullanılabilir
        for (Employee employee : employees) {
            employeeResponses.add(mapper.toResponse(employee));
        }
        unifiedJedis.setex(Constant.EMPLOYEES, Constant.CASH_TIME, gson.toJson(employeeResponses));
        return new SuccessDataResult<>(employeeResponses);
    }
}
