package com.github.asufana.presentation.fields

import com.github.asufana.presentation.sample.SampleObject
import com.github.asufana.presentation.sample.vo.Employee
import org.junit.Assert.*
import org.junit.Test

class FieldsFactoryTest {

    @Test
    fun testCreate() {
        val html = FieldsFactory.create(SampleObject.SAMPLE)
        assertEquals("hoge", html)
    }

}
