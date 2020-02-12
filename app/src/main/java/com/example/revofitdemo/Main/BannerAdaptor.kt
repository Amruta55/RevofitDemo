package com.example.revofitdemo.Main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.revofitdemo.R
import com.example.revofitdemo.databinding.InflateBannerViewBinding

class BannerAdaptor(val context: Context, val list: ArrayList<BannerList>) :
    RecyclerView.Adapter<BannerAdaptor.BannerDetail>() {

    var binding:InflateBannerViewBinding?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerDetail {
       binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.inflate_banner_view, parent, false
        )
        return BannerDetail(binding!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BannerDetail, position: Int) {
        var obj = list[position]
        if(!obj.headline.isNullOrEmpty()){
            binding!!.bannerTxt.setText(obj.headline)
        }else{
            binding!!.bannerTxt.setText(obj.headline1)
        }


        Glide.with(context).load(obj.thumbnail).into(binding!!.bannerImg)

    }


    class BannerDetail(itemView: InflateBannerViewBinding) :
        RecyclerView.ViewHolder(itemView.root) {

    }
}