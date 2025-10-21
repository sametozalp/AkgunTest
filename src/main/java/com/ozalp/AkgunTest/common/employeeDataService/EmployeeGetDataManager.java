package com.ozalp.AkgunTest.common.employeeDataService;

import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeGetDataManager implements EmployeeDataService {

    private final CashEmployeeDataManager cashEmployeeDataManager;
    private final DbEmployeeDataManager dbEmployeeDataManager;

    @Override
    public List<EmployeeResponse> getData() {
        List<EmployeeResponse> responses = cashEmployeeDataManager.getData();
        if (responses.isEmpty()) {
            responses = dbEmployeeDataManager.getData();
        }
        return responses;
    }
}
