package com.github.asufana.presentation.sample.vo;

import javax.persistence.Embeddable;

@Embeddable
public class EmpId extends AbstractValueObject {
    
    private final Integer value;
    
    public EmpId(Integer value) {
        this.value = value;
    }
    
    public Integer value() {
        return value;
    }

    public String toString(){
        return value.toString();
    }

}
