package com.itis.myApp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.myApp.databinding.FragmentHiddenBinding


class HiddenFragment : Fragment(R.layout.fragment_hidden) {
    private var binding: FragmentHiddenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHiddenBinding.bind(view)

        binding?.run {
            btnToHistory.setOnClickListener {
                findNavController().navigate(R.id.action_hiddenFragment_to_historyFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}