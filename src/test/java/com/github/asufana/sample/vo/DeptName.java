package com.github.asufana.sample.vo;

import com.github.asufana.presentation.annotations.View;

import javax.persistence.Embeddable;

@View(name="部署名")
@Embeddable
public class DeptName extends AbstractValueObject {

    private final String value;

    public DeptName(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }

}
