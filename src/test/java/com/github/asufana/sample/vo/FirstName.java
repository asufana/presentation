package com.github.asufana.sample.vo;

import javax.persistence.Embeddable;

import com.github.asufana.presentation.annotations.View;

@View(name="名")
@Embeddable
public class FirstName extends AbstractValueObject {

    private final String value;

    public FirstName(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }

}
