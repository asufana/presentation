package models;

import static org.hamcrest.CoreMatchers.*;
import models.vo.*;

import org.junit.*;

import play.test.*;

public class EntityTest extends UnitTest {
    
    @Test
    public void test() {
        final SampleObject object = new SampleObject(new Employee(1, "Hanafusa", "Makoto"));
        final String html = object.toHtml();
        
        assertThat(html.length() > 0, is(true));
        System.out.println(html);
    }
}
