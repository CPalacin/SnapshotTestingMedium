package com.carlos.snapshottestingmedium.tests

import android.view.View

class Variation<D> (val permutation: (View, D) -> Unit, vararg val data: D) {
    fun size() = data.size
    fun applyPermutation(view: View, position: Int) = permutation(view, data[position])
}