package com.example.revofitdemo.Main

import android.content.Context
import android.util.Log
import com.example.revofitdemo.Services.APIInterface
import com.example.revofitdemo.Services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val context: Context, val view: MainContractor.View) :
    MainContractor.Presenter {

    var bannerList = ArrayList<BannerList>()
    var recipeList = ArrayList<RecipeList>()
    var listData = ArrayList<ListData1>()
    override fun getData() {

        var response: Call<MainModel>? =
            RetrofitClient.getClient().create(APIInterface::class.java).doGetListResources()

        response?.enqueue(object : Callback<MainModel> {
            override fun onFailure(call: Call<MainModel>?, t: Throwable?) {
                Log.i("RetrofitDemo", "Exception is", t)
            }

            override fun onResponse(call: Call<MainModel>?, response: Response<MainModel>?) {
                bannerList.clear()
                recipeList.clear()
                if (response!!.isSuccessful) {
                    Log.i("RetrofitDemo", "Response is" + response.body().toString())

                    bannerList.addAll(response.body().mainContent?.banner?.data!!)
                    listData.addAll(response.body().mainContent?.list?.data!!)
                    recipeList.addAll(response.body().mainContent?.recipe?.data!!)

                    view.addBannerList(bannerList)
                    view.addRecipeList(recipeList)
                    view.addList(listData)
                }
            }

        })

    }


}