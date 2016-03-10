package com.github.asufana.presentationjava;

import com.github.asufana.presentation.sample.SampleObject;
import com.github.asufana.presentationjava.PresentationImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresentationImplTest {

    @Test
    //フィールド一覧取得
    public void testToHtml() {
        String html = PresentationImpl.toHtml(SampleObject.SAMPLE);
        assertThat(html, CoreMatchers.is(CoreMatchers.notNullValue()));

        System.out.println(html);
    }

    @Test
    //フィールド一覧取得
    public void testToHtmlWithLayout() {
        String layout = "employee.empId," + "employee.empName," + "employee.deptName";
        String html = PresentationImpl.toHtml(SampleObject.SAMPLE, layout);
        assertThat(html, CoreMatchers.is(CoreMatchers.notNullValue()));

        System.out.println(html);
    }

}