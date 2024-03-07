package com.lcwd.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PayrollSystemTest {
    @Test
    public void addEmployeeToPayrollTest(){
        PayrollSystem payrollSystem = new PayrollSystem();
        Employee employee = new Employee("Ravi Sharma", 5000);
        payrollSystem.setEmployees(employee);

        Assertions.assertNotNull(payrollSystem.getEmployees());
        Assertions.assertEquals(employee, payrollSystem.getEmployees().get(0));
    }
}
