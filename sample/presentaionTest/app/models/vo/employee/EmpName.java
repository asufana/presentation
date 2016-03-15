package models.vo.employee;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "社員名")
@Embeddable
public class EmpName extends AbstractValueObject {
    
    private final LastName lastName;
    private final FirstName firstName;
    
    public EmpName(final String lastName, final String firstName) {
        this(new LastName(lastName), new FirstName(firstName));
    }
    
    EmpName(final LastName lastName, final FirstName firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
    
}
