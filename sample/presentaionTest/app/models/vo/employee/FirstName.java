package models.vo.employee;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "名")
@Embeddable
public class FirstName extends AbstractValueObject {
    
    private final String value;
    
    public FirstName(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
