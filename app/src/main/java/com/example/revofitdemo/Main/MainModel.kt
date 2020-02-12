package com.example.revofitdemo.Main

import com.google.gson.annotations.SerializedName



data class MainModel (
    @SerializedName("response")
    private val response: Response? = null,
    @SerializedName("main_content") val mainContent: MainContent? = null
)


data class Response(
    @SerializedName("code")
    
    private val code: String? = null,
    @SerializedName("message")
    
    private val message: String? = null
)


data class MainContent(
    @SerializedName("list") val list: List1? = null,
    @SerializedName("banner") val banner: Banner? = null,
    @SerializedName("recipe") val recipe: Recipe? = null
)

data class List1 (
    @SerializedName("title")
    
    private val title: String? = null,
    @SerializedName("count")
    
    private val count: Int? = null,
    @SerializedName("data") val data: List<ListData1>? = null
)

data class ListData1(
    @SerializedName("headline") val headline: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("image")
    
    public val image: String? = null,
    @SerializedName("banner_image") val bannerImage: String? = null
)

data class Banner(
    @SerializedName("title")
    
    private val title: String? = null,
    @SerializedName("count")
    
    private val count: Int? = null,
    @SerializedName("data") val data: List<BannerList>? = null
)

data class BannerList(
    @SerializedName("headline") val headline: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("headline_1") val headline1: String? = null

)

data class Recipe(
    @SerializedName("totalrecords")
    
    private val totalrecords: Int? = null,
    @SerializedName("recipe_count")
    
    private val recipeCount: Int? = null,
    @SerializedName("data") val data: List<RecipeList>? = null
)

data class RecipeList(
    @SerializedName("name") val name: String? = null,
    @SerializedName("meal_time") val mealTime: String? = null,
    @SerializedName("smallthumbnail") val smallthumbnail: String? = null
)