package com.github.asufana.presentation.fields

import com.github.asufana.sample.SampleObject
import org.junit.Assert
import org.junit.Test


class FieldsTest {

    @Test
    fun testDescTableDefaultColumnLayout() {
        val fields = FieldsFactory.create(SampleObject.SAMPLE)
        val layout = fields.descTableDefaultColumnLayout()

        Assert.assertEquals(true, layout.length > 0)
        println(layout)
    }
}
