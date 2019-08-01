package com.carlos.snapshottestingmedium

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class PairNumberTest(val number: Int) {

    companion object {
        @JvmStatic
        @Parameters(name = "Test for number {0}")
        fun data() = listOf(2, 4, 6, 7)
    }

    @Test
    fun testPairNumber() {
        assertEquals(0, number % 2)
    }
}
