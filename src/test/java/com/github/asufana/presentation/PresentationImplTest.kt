package com.github.asufana.presentation

import com.github.asufana.presentation.exceptions.PresentationException
import com.github.asufana.sample.SampleObject
import org.junit.Assert.*
import org.junit.Test

class PresentationImplTest {

    //HTML変換（デフォルトレイアウト）
    @Test
    fun testToHtml() {
        val html = PresentationImpl.toHtml(SampleObject.SAMPLE)

        //html変換されること
        assertEquals(true, html.length > 0)
        println(html)
    }

    //HTML変換（指定レイアウト）
    @Test
    fun testToHtmlWithLayout() {
        val layout = "employee.empId\n" +
                "employee.empId\n" +
                "employee.empName.lastName, employee.empName.firstName\n" +
                "employee.deptName"
        val html = PresentationImpl.toHtml(SampleObject.SAMPLE, layout)

        //html変換されること
        assertEquals(true, html.length > 0)
        println(html)
    }

    //HTML変換（レイアウト不正で例外）
    @Test(expected = PresentationException::class)
    fun testToHtmlWithInvalidLayout() {
        val layout = "employee.invalid"

        //例外発生すること
        PresentationImpl.toHtml(SampleObject.SAMPLE, layout)
    }

    //HTML変換（レイアウト不正を例外としない）
    @Test
    fun testToHtmlWithInvalidLayoutWithoutException() {
        val layout = "employee.invalid"

        //例外発生しないこと
        val html = PresentationImpl.toHtmlWithtoutException(SampleObject.SAMPLE, layout)

        //html変換されること
        assertEquals(true, html.length > 0)
        println(html)
    }

}


