package com.perusu.vm_pro.features.flowEmit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.perusu.vm_pro.R
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.model.User
import com.perusu.vm_pro.features.byRepo.VMFactory
import com.perusu.vm_pro.features.common.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_flow_emit.*
import kotlinx.android.synthetic.main.fragment_flow_emit.view.*
import kotlinx.android.synthetic.main.widget_progress.*

class FlowEmitFragment : Fragment() {

    private val flowEmitViewModel by viewModels<FlowEmitViewModel> {
        VMFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flow_emit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerEmit.layoutManager = LinearLayoutManager(requireContext())
        subscribeToChanges()
    }

    private fun subscribeToChanges() {

        flowEmitViewModel.fetchUserList.observe(viewLifecycleOwner, Observer { resultOf ->
            when (resultOf) {
                is ResultOf.Progress -> progressLayout?.let {
                    it.visibility = if (resultOf.loading) View.VISIBLE else View.GONE
                }
                is ResultOf.Success -> recyclerEmit.adapter = RecyclerAdapter(resultOf.value)
                is ResultOf.Empty -> {
                }
                is ResultOf.Failure -> {
                }
            }
        })

    }

}