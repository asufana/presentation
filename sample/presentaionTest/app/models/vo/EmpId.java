package models.vo;

import javax.persistence.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "社員番号")
@Embeddable
public class EmpId extends AbstractValueObject {
    
    private final Integer value;
    
    public EmpId(final Integer value) {
        this.value = value;
    }
    
    public Integer value() {
        return value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
    
}
