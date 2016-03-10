package com.github.asufana.presentation

import com.github.asufana.presentation.sample.SampleObject
import com.github.asufana.presentation.sample.vo.Employee
import org.junit.Assert.*
import org.junit.Test

class PresentationImplTest {

    @Test
    fun test() {
        val foo = PresentationImpl.toHtml(SampleObject.SAMPLE)
        assertEquals("SAMPLE,employee", foo)
    }

}


