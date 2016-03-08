package com.github.asufana.presentation.fields

import com.github.asufana.presentation.sample.SampleObject
import com.github.asufana.presentation.sample.vo.Employee
import org.junit.Assert.*
import org.junit.Test

class FieldsFactoryTest {

    @Test
    fun testCreate() {
        val obj = SampleObject(Employee(1, "hana"));
        val html = FieldsFactory.create(obj)
        assertEquals("hoge", html)
    }

}
