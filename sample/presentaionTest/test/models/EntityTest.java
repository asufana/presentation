package models;

import static org.hamcrest.CoreMatchers.*;

import org.junit.*;

import play.test.*;

public class EntityTest extends UnitTest {
    
    @Test
    public void test() {
        final Entity entity = new Entity(1, "hoge");
        assertThat(entity.toHtml(), is("html!!!"));
    }
    
}
