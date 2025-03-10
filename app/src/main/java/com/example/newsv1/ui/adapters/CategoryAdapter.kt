package com.example.news.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsv1.domain.constants.Category
import com.example.newsv1.databinding.CategoryItemLeftBinding
import com.example.newsv1.databinding.CategoryItemRightBinding

class CategoryAdapter(
    var Categories: List<Category> = Category.getCategories(),
    val onCategoryClick: (categoryId: String) -> Unit
) :
    Adapter<CategoryAdapter.BaseViewHolder>() {

    sealed class BaseViewHolder(binding: ViewGroup) : ViewHolder(binding) {
        abstract fun bind(category: Category)
    }

    inner class ViewHolder1(private var binding: CategoryItemLeftBinding) : BaseViewHolder(binding.root) {
        override fun bind(category: Category) {
            binding.categoryName.setText(category.title)
            binding.categoryImage.setImageResource(category.imgRes)
            binding.root.setOnClickListener{
                onCategoryClick(category.id)
            }
        }
    }

    inner class ViewHolder2(private var binding: CategoryItemRightBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(category: Category) {
            binding.categoryName.setText(category.title)
            binding.categoryImage.setImageResource(category.imgRes)
            binding.root.setOnClickListener{
                onCategoryClick(category.id)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            0 -> {
                val binding = CategoryItemLeftBinding.inflate(layoutInflater, parent, false)
                ViewHolder1(binding)
            }

            else -> {
                val binding = CategoryItemRightBinding.inflate(layoutInflater, parent, false)
                ViewHolder2(binding)
            }
        }
    }

    override fun getItemCount(): Int = Categories.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val category = Categories[position]
        holder.bind(category)
    }
}