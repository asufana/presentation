package com.github.asufana.presentation.sample.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Employee {
    
    private final EmpId empId;
    private final EmpName empName;
    private final DeptName deptName = null;
    
    public Employee(Integer empId, String lastName, String firstName) {
        this(new EmpId(empId), new EmpName(lastName, firstName));
    }
    
    public Employee(EmpId empId, EmpName empName) {
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
