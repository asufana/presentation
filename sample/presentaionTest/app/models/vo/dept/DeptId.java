package models.vo.dept;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "部署コード")
@Embeddable
public class DeptId extends AbstractValueObject {
    
    private final Integer value;
    
    public DeptId(final Integer value) {
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
