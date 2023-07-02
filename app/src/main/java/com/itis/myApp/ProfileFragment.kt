package com.itis.myApp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.itis.myApp.databinding.FragmentProfileBinding
import com.itis.myApp.utils.showSnackbar
import kotlin.random.Random

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null
    private var adapter: FruitAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val name = arguments?.getString(ARG_NAME)
        Log.e("ProfileFragment", name.orEmpty())

        initAdapter()

        binding?.tvTitle?.setOnClickListener {
            adapter?.updateDataset(
                FruitRepository.list.subList(0, Random.nextInt(5))
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = FruitAdapter(
            list = FruitRepository.list,
            glide = Glide.with(this),
            onItemClick = { city ->
                binding?.root?.showSnackbar(city.name)
            }
        )
        binding?.rvFruit?.adapter = adapter
        binding?.rvFruit?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_AGE = "ARG_AGE"

        fun createBundle(name : String, age : Int) : Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            bundle.putInt(ARG_AGE, age)
            return bundle
        }
    }
}