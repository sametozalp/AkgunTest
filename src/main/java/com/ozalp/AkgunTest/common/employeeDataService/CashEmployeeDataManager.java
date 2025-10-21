package com.ozalp.AkgunTest.common.employeeDataService;

import com.google.gson.Gson;
import com.ozalp.AkgunTest.common.Constant;
import com.ozalp.AkgunTest.model.dtos.responses.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CashEmployeeDataManager implements EmployeeDataService {

    private final UnifiedJedis unifiedJedis;
    private final Gson gson;

    @Override
    public List<EmployeeResponse> getData() {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        String redisJson = unifiedJedis.get(Constant.EMPLOYEES);
        if (redisJson != null) {
            EmployeeResponse[] array = gson.fromJson(redisJson, EmployeeResponse[].class); // liste verince olmuyor ama dizilerde çalışıyormuş
            employeeResponses = Arrays.asList(array);
        }
        return employeeResponses;
    }
}
