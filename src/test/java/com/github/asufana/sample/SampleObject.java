package com.github.asufana.sample;

import com.github.asufana.sample.vo.Employee;

public class SampleObject {

    public static final SampleObject SAMPLE =
            new SampleObject(new Employee(1, "Hanafusa", "Makoto"));

    private final Employee employee;
    
    public SampleObject(Employee employee) {
        this.employee = employee;
    }
    
    public Employee employee() {
        return employee;
    }
}
