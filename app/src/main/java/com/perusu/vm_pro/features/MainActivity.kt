package com.perusu.vm_pro.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.perusu.vm_pro.features.by.ByExViewModel
import com.perusu.vm_pro.R

class MainActivity : AppCompatActivity() {

   // private val byExViewModel: ByExViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*byExViewModel.obMessage.observe(this, {
            findViewById<AppCompatEditText>(R.id.etMessage)
                .setText(String.format("%s", it.toString()))
        })

        findViewById<Button>(R.id.btnSend).setOnClickListener {
            byExViewModel.obMessage.value =
                findViewById<AppCompatEditText>(R.id.etMessage).text.toString()
        }*/
    }
}