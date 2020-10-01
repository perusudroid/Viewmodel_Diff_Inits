package com.perusu.vm_pro.features.by

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.perusu.vm_pro.R
import kotlinx.android.synthetic.main.one_fragment.*

class ByExOneFragment : Fragment() {

    private val byExViewModel: ByExViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.one_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        byExViewModel.obMessage.observe(viewLifecycleOwner, Observer {
            etText.setText(String.format("%s", it.toString()))
        })

        view.findViewById<AppCompatButton>(R.id.btnGo).setOnClickListener {
            byExViewModel.obMessage.value =
                view.findViewById<AppCompatEditText>(R.id.etText).text.toString()
            findNavController().navigate(R.id.twoFragment)
        }
    }
}