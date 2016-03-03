package com.github.asufana.presentation.sample.vo;

public class EmpName extends AbstractValueObject {
    
    private final String value;
    
    public EmpName(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
}
