package models.vo.dept;

import javax.persistence.*;

@Embeddable
public class Dept {
    
    public final DeptId deptId;
    public final DeptName deptName;
    
    public Dept(final Integer deptId, final String deptName) {
        this(new DeptId(deptId), new DeptName(deptName));
    }
    
    public Dept(final DeptId deptId, final DeptName deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
    
}
