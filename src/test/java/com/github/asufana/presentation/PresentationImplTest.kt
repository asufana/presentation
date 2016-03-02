package com.github.asufana.presentation

import org.junit.Assert.*
import org.junit.Test

class PresentationImplTest {

    @Test
    fun test() {
        val foo = PresentationImpl.toHtml()
        assertEquals(foo, "html!!!")
    }

}


