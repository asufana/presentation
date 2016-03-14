package com.github.asufana.presentation

import com.github.asufana.sample.SampleObject
import org.junit.Assert.*
import org.junit.Test

class PresentationImplTest {

    //HTML変換（デフォルトレイアウト）
    @Test
    fun testToHtml() {
        val html = PresentationImpl.toHtml(SampleObject.SAMPLE)
        assertEquals(true, html.length > 0)

        println(html)
    }

    //HTML変換
    @Test
    fun testToHtmlWithLayout() {
        val layout = "employee.empId, employee.empName.lastName\n employee.empName.firstName, employee.deptName"

        val html = PresentationImpl.toHtml(SampleObject.SAMPLE, layout)
        assertEquals(true, html.length > 0)

        println(html)
    }

}


