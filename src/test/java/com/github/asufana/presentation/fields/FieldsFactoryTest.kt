package com.github.asufana.presentation.fields

import com.github.asufana.presentation.sample.SampleObject
import org.junit.Assert.*
import org.junit.Test

class FieldsFactoryTest {

    @Test
    fun testCreate() {
        val fields = FieldsFactory.create(SampleObject.SAMPLE)
        assertEquals(fields != null, true)
        assertEquals(fields.size() > 0, true)
    }

}
