package com.ozalp.AkgunTest.common.employeeDataService;

import com.google.gson.Gson;
import com.ozalp.AkgunTest.common.Constant;
import com.ozalp.AkgunTest.dataAccess.EmployeeRepository;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import com.ozalp.AkgunTest.model.entities.concretes.Employee;
import com.ozalp.AkgunTest.model.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DbEmployeeDataManager implements EmployeeDataService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final UnifiedJedis unifiedJedis;
    private final Gson gson;

    @Override
    public List<EmployeeResponse> getData() {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        List<Employee> employees = repository.findAll();
        // for yerine streams kullanılabilir
        for (Employee employee : employees) {
            employeeResponses.add(mapper.toResponse(employee));
        }
        unifiedJedis.setex(Constant.EMPLOYEES, Constant.CASH_TIME, gson.toJson(employeeResponses));
        return employeeResponses;
    }
}
