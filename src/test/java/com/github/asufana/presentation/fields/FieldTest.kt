package com.github.asufana.presentation.fields

import com.github.asufana.sample.SampleObject
import org.junit.Assert.*
import org.junit.Test

class FieldTest {

    @Test
    fun testField() {
        val field = Field(listOf(),
                SampleObject.SAMPLE.javaClass.declaredFields[0],
                SampleObject.SAMPLE)
        assertEquals(field != null, true)
    }

}
