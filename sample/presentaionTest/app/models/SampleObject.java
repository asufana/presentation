package models;

import models.vo.*;

import com.github.asufana.presentation.*;

public class SampleObject implements Presentation {
    
    public final Employee employee;
    
    public SampleObject(final Employee employee) {
        this.employee = employee;
    }
}
