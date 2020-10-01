package com.perusu.vm_pro.features.byRepo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.model.User
import com.perusu.vm_pro.R
import com.perusu.vm_pro.features.common.RecyclerAdapter
import kotlinx.android.synthetic.main.widget_progress.*

class ByRepoFragment : Fragment() {

    private val byRepoViewModel by viewModels<ByRepoViewModel> {
        VMFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_by_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToChanges(view)
        byRepoViewModel.fetchUserList()
    }

    private fun subscribeToChanges(view: View) {
        byRepoViewModel.obUserList.observe(viewLifecycleOwner, Observer { resultOf ->
            when (resultOf) {
                is ResultOf.Progress -> progressLayout?.let {
                    it.visibility = if (resultOf.loading) View.VISIBLE else View.GONE
                }
                is ResultOf.Success -> populateRecyclerList(resultOf.value, view)
                is ResultOf.Empty -> showMessage(resultOf.message)
                is ResultOf.Failure -> showMessage(resultOf.message ?: "onFailure")
            }
        })
    }

    private fun populateRecyclerList(userList: List<User>, view: View) {
        Log.d("ObExFragment", "populateRecyclerList: ${userList.size}")
        view.findViewById<RecyclerView>(R.id.recyclerItems2)?.adapter = RecyclerAdapter(userList)
    }

    private fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}