package com.perusu.vm_pro.features.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.perusu.vm_pro.R
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.features.byRepo.VMFactory
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.widget_progress.*

class LoginFragment : Fragment() {

    private val authViewModel by viewModels<AuthViewModel> {
        VMFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToChanges()

        btnLoginUser.setOnClickListener {
            authViewModel.doLogin()
        }

        btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun subscribeToChanges() {
        authViewModel.obLogin.observe(viewLifecycleOwner) { resultOf ->
            when (resultOf) {
                is ResultOf.Progress -> progressLayout?.let {
                    it.visibility = if (resultOf.loading) View.VISIBLE else View.GONE
                }
                is ResultOf.Success -> findNavController().navigate(R.id.action_loginFragment_to_nav_graph)
            }
        }
    }


}