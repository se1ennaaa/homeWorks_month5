package com.example.dz.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz.databinding.ItemHistoryBinding
import com.example.dz.remote.LoveModel

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val data = arrayListOf<LoveModel>()

    fun addTasks(list: List<LoveModel>) {
        data.clear()
        data.addAll(list)
        data.sortByDescending { it.id }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.tvFFirstName.text = loveModel.firstName
            binding.tvFSecondName.text = loveModel.secondName
            binding.tvPercentage.text = loveModel.persentage
        }

    }
}