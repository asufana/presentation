package com.github.asufana.presentation.sample.vo;

import com.github.asufana.presentationjava.annotations.View;

import javax.persistence.Embeddable;

@View(name="あああ")
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
