package models.vo.employee;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "姓")
@Embeddable
public class LastName extends AbstractValueObject {
    
    private final String value;
    
    public LastName(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
