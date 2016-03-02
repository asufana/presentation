package models;

import play.db.jpa.*;

import com.github.asufana.presentation.*;

@javax.persistence.Entity
public class Entity extends Model implements Presentation {
    
    public final Integer empId;
    public final String empName;
    
    public Entity(final Integer empId, final String empName) {
        this.empId = empId;
        this.empName = empName;
    }
}
