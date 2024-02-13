package com.example.cardreader

import org.junit.Test
import org.junit.Assert.*

class InputValidationTest {

    @Test
    fun `test string is not empty`() {
        val cardInput = "Hello, World!"
        assertTrue("String is empty", cardInput.isNotEmpty())
    }

    @Test
    fun `test string length is not less than 6`() {
        val cardInput = "503938"
        assertTrue("String length is less than 6", cardInput.length >= 6)
    }



}