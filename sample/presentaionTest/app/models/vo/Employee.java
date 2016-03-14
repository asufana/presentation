package models.vo;

import javax.persistence.*;

@Embeddable
public class Employee {
    
    private final EmpId empId;
    private final EmpName empName;
    private final DeptName deptName = null;
    
    public Employee(final Integer empId, final String lastName, final String firstName) {
        this(new EmpId(empId), new EmpName(lastName, firstName));
    }
    
    public Employee(final EmpId empId, final EmpName empName) {
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
