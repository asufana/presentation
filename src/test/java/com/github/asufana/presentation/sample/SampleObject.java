package com.github.asufana.presentation.sample;

import com.github.asufana.presentation.sample.vo.Employee;

public class SampleObject {
    
    private final Employee employee;
    
    public SampleObject(Employee employee) {
        this.employee = employee;
    }
    
    public Employee employee() {
        return employee;
    }
}
