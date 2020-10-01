package com.perusu.vm_pro.features.by

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.perusu.vm_pro.R
import kotlinx.android.synthetic.main.two_fragment.*

class ByExTwoFragment : Fragment() {

    private val byExViewModel: ByExViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.two_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        byExViewModel.obMessage.observe(viewLifecycleOwner, Observer {
            etText2.setText(String.format("%s", it.toString()))
        })

        btnGo2.setOnClickListener {
            byExViewModel.obMessage.value = etText2.text.toString()
            findNavController().navigateUp()
        }
    }
}