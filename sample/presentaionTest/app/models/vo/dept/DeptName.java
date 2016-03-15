package models.vo.dept;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "部署名")
@Embeddable
public class DeptName extends AbstractValueObject {
    
    private final String value;
    
    public DeptName(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
