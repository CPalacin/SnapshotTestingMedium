package com.carlos.snapshottestingmedium.permutations

import android.view.View

class Permutation<D> (val permutation: (View, D) -> Unit, vararg val data: D){
    fun size() = data.size
    fun applyPermutation(view: View, position: Int) = permutation(view, data[position])
}