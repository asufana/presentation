package com.github.asufana.presentation.sample.vo;

import com.github.asufana.presentationjava.annotations.View;

import javax.persistence.Embeddable;

@View(name="社員名")
@Embeddable
public class EmpName extends AbstractValueObject {

    private final LastName lastName;
    private final FirstName firstName;

    public EmpName(String lastName, String firstName) {
        this(new LastName(lastName), new FirstName(firstName));
    }
    EmpName(LastName lastName, FirstName firstName){
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public String toString(){
        return lastName + " " + firstName;
    }

}
