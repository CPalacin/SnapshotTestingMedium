package com.carlos.snapshottestingmedium.tests.configuration

import androidx.annotation.LayoutRes
import com.carlos.snapshottestingmedium.tests.Variation

abstract class TestConfiguration(val testName: String, @LayoutRes val layout: Int, vararg val variation: Variation<*>) {
    override fun toString() = testName
}