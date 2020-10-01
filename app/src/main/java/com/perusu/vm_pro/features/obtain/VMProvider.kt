package com.perusu.vm_pro.features.obtain

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

object VMProvider {

    fun obtainTwoViewModel(frag: Fragment): ObExViewModel {
        return ViewModelProvider(
            frag,
            ViewModelFactory.getInstance()
        ).get(ObExViewModel::class.java)
    }

}