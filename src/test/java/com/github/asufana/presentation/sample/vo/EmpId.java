package com.github.asufana.presentation.sample.vo;

public class EmpId extends AbstractValueObject {
    
    private final Integer value;
    
    public EmpId(Integer value) {
        this.value = value;
    }
    
    public Integer value() {
        return value;
    }
    
}
