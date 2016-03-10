package com.github.asufana.presentation.sample;

import com.github.asufana.presentation.sample.vo.Employee;

public class SampleObject {

    public static final SampleObject SAMPLE = new SampleObject(new Employee(1, "hana"));

    private final Employee employee;

    public SampleObject(Employee employee) {
        this.employee = employee;
    }

    public Employee employee() {
        return employee;
    }
}
