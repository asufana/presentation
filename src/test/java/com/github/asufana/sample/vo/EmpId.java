package com.github.asufana.sample.vo;

import com.github.asufana.presentation.annotations.View;

import javax.persistence.Embeddable;

@View(name="社員番号")
@Embeddable
public class EmpId extends AbstractValueObject {
    
    private final Integer value;
    
    public EmpId(Integer value) {
        this.value = value;
    }

    public String toString(){
        return value.toString();
    }

}
