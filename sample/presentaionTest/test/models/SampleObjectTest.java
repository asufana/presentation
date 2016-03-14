package models;

import static org.hamcrest.CoreMatchers.*;
import models.vo.*;

import org.junit.*;

import play.test.*;

public class SampleObjectTest extends UnitTest {
    
    @Test
    public void testToHtml() {
        final SampleObject object = new SampleObject(new Employee(1, "Hanafusa", "Makoto"));
        final String html = object.toHtml();
        
        assertThat(html.length() > 0, is(true));
        System.out.println(html);
    }
}
