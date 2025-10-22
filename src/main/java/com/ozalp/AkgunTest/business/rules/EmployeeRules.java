package com.ozalp.AkgunTest.business.rules;

import com.ozalp.AkgunTest.common.Messages;
import com.ozalp.AkgunTest.dataAccess.EmployeeRepository;
import com.ozalp.AkgunTest.model.entities.concretes.Employee;
import com.ozalp.AkgunTest.common.exceptions.errors.RulesException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeRules {

    private final EmployeeRepository employeeRepository;

    public void checkPhoneNumber(Employee employee) {
        if (employeeRepository.existsByPhoneNumber(employee.getPhoneNumber())) {
            throw new RulesException(Messages.EmployeeMessages.PHONE_NUMBER_ALREADY_EXISTS);
        }
    }

    public void checkSocialSecurityNumber(Employee employee) {
        if (employeeRepository.existsBySocialSecurityNumber(employee.getSocialSecurityNumber())) {
            throw new RulesException(Messages.EmployeeMessages.SOCIAL_SECURITY_ALREADY_EXISTS);
        }
    }
}
