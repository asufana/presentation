package com.github.asufana.sample.vo;

import com.github.asufana.presentation.annotations.View;

import javax.persistence.Embeddable;

@View(name="姓")
@Embeddable
public class LastName extends AbstractValueObject {

    private final String value;

    public LastName(String value) {
        this.value = value;
    }
    
    public String toString(){
        return value;
    }

}
