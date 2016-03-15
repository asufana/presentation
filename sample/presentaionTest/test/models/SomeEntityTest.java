package models;

import static org.hamcrest.CoreMatchers.*;

import org.junit.*;

import play.test.*;

public class SomeEntityTest extends UnitTest {
    
    @Test
    public void testToHtml() {
        final String html = SomeEntity.SAMPLE.toHtml();
        
        assertThat(html.length() > 0, is(true));
        System.out.println(html);
    }
}
