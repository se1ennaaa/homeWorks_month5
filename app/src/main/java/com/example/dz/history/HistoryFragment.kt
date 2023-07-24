package com.example.dz.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz.R
import com.example.dz.data.local.LoveDao
import com.example.dz.databinding.FragmentHistoryBinding
import com.example.dz.remote.LoveModel
import javax.inject.Inject

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    @Inject
    lateinit var dataBase: LoveDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = dataBase.getAllSort()
        var data = ""

        list.forEach {
            data += "${it.firstName}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tПроцент:\n❤\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t${it.persentage}\n${it.secondName}\n\n"
        }

        binding.resultTv.text = data
    }

}