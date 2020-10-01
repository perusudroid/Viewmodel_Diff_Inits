package com.perusu.vm_pro.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.perusu.vm_pro.R
import com.perusu.vm_pro.features.common.ListAdapter

class SampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerSample).adapter =
            ListAdapter(
                listOf("Obtain ViewModel", "By ViewModels", "By ViewModels Repo"),
                onItemClicked
            )
    }

    private val onItemClicked: (Int) -> Unit = {
        when (it) {
            0 -> findNavController().navigate(R.id.action_sampleFragment_to_obExFragment)
            1 -> findNavController().navigate(R.id.action_sampleFragment_to_oneFragment)
            2 -> findNavController().navigate(R.id.action_sampleFragment_to_byRepoFragment)
        }
    }


}