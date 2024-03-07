package com.lcwd.test;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees;
    public PayrollSystem(){
        this.employees = new ArrayList<>();
    }
    public void setEmployees(Employee emp){
        employees.add(emp);
    }
    public  List<Employee> getEmployees(){
        return employees;
    }
}
