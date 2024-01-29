package com.vaibhav.musicapp.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vaibhav.musicapp.databinding.CategoryItemRecyclerRowBinding
import com.vaibhav.musicapp.models.CategoryModel

class CategoryAdapter (private val categoryList: List<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding : CategoryItemRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root){
        //bind the data with views
        fun bindData(category : CategoryModel){
            binding.nameTextView.text = category.name
            Glide.with(binding.coverImageView).load(category.coverUrl).into(binding.coverImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}