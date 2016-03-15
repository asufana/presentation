package models.vo.employee;

import javax.persistence.*;

import models.vo.*;

import com.github.asufana.presentation.annotations.*;

@View(name = "社員番号", thWidth = 15, valueMethod = "toHtml")
@Embeddable
public class EmpId extends AbstractValueObject {
    
    private final Integer value;
    
    public EmpId(final Integer value) {
        this.value = value;
    }
    
    public String toHtml() {
        return String.format("<a href=\"#\">%s</a>", toString());
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
    
}
