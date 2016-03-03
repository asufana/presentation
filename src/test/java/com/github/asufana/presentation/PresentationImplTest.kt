package com.github.asufana.presentation

import com.github.asufana.presentation.sample.SampleObject
import com.github.asufana.presentation.sample.vo.Employee
import org.junit.Assert.*
import org.junit.Test

class PresentationImplTest {

    @Test
    fun test() {
        val obj = SampleObject(Employee(1, "hana"));
        val foo = PresentationImpl.toHtml(obj)
        assertEquals("employee", foo)
    }

}


