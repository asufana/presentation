package models;

import models.vo.dept.*;
import models.vo.employee.*;

import com.github.asufana.presentation.*;

public class SomeEntity implements Presentation {
    
    public static final SomeEntity SAMPLE = new SomeEntity(new Employee(1, "Hanafusa", "Makoto"),
                                                           new Dept(100, "営業"));
    public final Employee employee;
    public final Dept dept;
    
    public SomeEntity(final Employee employee, final Dept dept) {
        this.employee = employee;
        this.dept = dept;
    }
}
