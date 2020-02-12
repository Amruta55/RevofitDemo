package com.example.revofitdemo.Main

interface MainContractor {

    interface View{
        fun setBannerAdaptor(list:ArrayList<BannerList>)
        fun setRecipeAdaptor(list:ArrayList<RecipeList>)
        fun addBannerList(list:ArrayList<BannerList>)
        fun addRecipeList(list:ArrayList<RecipeList>)
        fun addList(list:ArrayList<ListData1>)
    }


    interface Presenter{
        fun getData()
    }
}