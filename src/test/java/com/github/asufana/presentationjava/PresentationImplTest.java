package com.github.asufana.presentationjava;

import com.github.asufana.sample.SampleObject;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresentationImplTest {

    @Test
    //HTML生成
    public void testToHtml() {
        String html = PresentationImpl.toHtml(SampleObject.SAMPLE);
        assertThat(html, CoreMatchers.is(CoreMatchers.notNullValue()));

        System.out.println(html);
    }

    @Test
    //HTML生成（レイアウト指定）
    public void testToHtmlWithLayout() {
        String layout = "employee.empId,"
                + "employee.empName.lastName,"
                + "employee.empName.firstName,"
                + "employee.deptName";
        String html = PresentationImpl.toHtml(SampleObject.SAMPLE, layout);
        assertThat(html, CoreMatchers.is(CoreMatchers.notNullValue()));

        System.out.println(html);
    }

}
