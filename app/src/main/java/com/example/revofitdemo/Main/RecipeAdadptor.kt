package com.example.revofitdemo.Main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.revofitdemo.R
import com.example.revofitdemo.databinding.InflateBannerViewBinding
import com.example.revofitdemo.databinding.InflateRecipeViewBinding

class RecipeAdadptor(val context: Context, val list: ArrayList<RecipeList>):RecyclerView.Adapter<RecipeAdadptor.RecipeDetail>() {

    var binding:InflateRecipeViewBinding?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeDetail {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.inflate_recipe_view, parent, false
        )
        return RecipeDetail(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecipeDetail, position: Int) {
        var obj = list[position]
        binding!!.recipeTitle.setText(obj.name)
        binding!!.recipeTxt.setText(obj.mealTime)

        Glide.with(context).load(obj.smallthumbnail).into(binding!!.recipeImg)

    }


    class RecipeDetail(itemView: InflateRecipeViewBinding) :
        RecyclerView.ViewHolder(itemView.root) {

    }

}