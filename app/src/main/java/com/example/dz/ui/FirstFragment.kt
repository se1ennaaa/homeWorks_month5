package com.example.dz.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dz.App
import com.example.dz.LoveViewModel
import com.example.dz.R
import com.example.dz.Utils
import com.example.dz.databinding.FragmentFirstBinding
import com.example.dz.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                if (firstEt.text.isNotEmpty() && secondEt.text.isNotEmpty()) {
                    viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                        .observe(viewLifecycleOwner) { loveModel ->
                            Log.d("ololo", "initClicker: ${loveModel}")
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf("result" to loveModel)
                            )
                            App.appDataBase.getDao().insert(loveModel)
                        }
                }
            }
        }
    }
}
