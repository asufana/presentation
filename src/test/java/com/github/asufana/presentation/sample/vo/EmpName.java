package com.github.asufana.presentation.sample.vo;

import com.github.asufana.presentationjava.annotations.View;

import javax.persistence.Embeddable;

@Embeddable
public class EmpName extends AbstractValueObject {
    
    private final String value;
    
    public EmpName(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }

}
