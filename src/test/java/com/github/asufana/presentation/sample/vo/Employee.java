package com.github.asufana.presentation.sample.vo;

public class Employee {
    
    private final EmpId empId;
    private final EmpName empName;
    
    public Employee(Integer empId, String empName) {
        this(new EmpId(empId), new EmpName(empName));
    }
    
    Employee(EmpId empId, EmpName empName) {
        this.empId = empId;
        this.empName = empName;
    }
    
    public EmpId empId() {
        return empId;
    }
    
    public EmpName empName() {
        return empName;
    }
}
