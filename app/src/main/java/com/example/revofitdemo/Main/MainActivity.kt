package com.example.revofitdemo.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.example.revofitdemo.R
import com.example.revofitdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainContractor.View, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onSliderClick(slider: BaseSliderView?) {

    }

    var list = ArrayList<ListData1>()
    var HashMapForURL= HashMap<String, String>()
    override fun addList(list: ArrayList<ListData1>) {

        list.addAll(list)
HashMapForURL.clear()
for(i in list.indices){
    HashMapForURL.put(list[i].headline.toString(), list[i].thumbnail.toString())
}



        for (name in HashMapForURL?.keys!!) {

            val textSliderView = TextSliderView(this@MainActivity)

            textSliderView
                .description("")
                .image(HashMapForURL!![name])
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .setOnSliderClickListener(this)

            textSliderView.bundle(Bundle())

            textSliderView.bundle
                .putString("extra", name)

            binding?.slider?.addSlider(textSliderView)
        }

        binding?.slider?.setPresetTransformer(SliderLayout.Transformer.DepthPage)

        binding?.slider?.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)

        binding?.slider?.setCustomAnimation(DescriptionAnimation())

        binding?.slider?.setDuration(3000)

        binding?.slider?.addOnPageChangeListener(this@MainActivity)

    }




    override fun addBannerList(list: ArrayList<BannerList>) {
        setBannerAdaptor(list)
    }

    override fun addRecipeList(list: ArrayList<RecipeList>) {
        setRecipeAdaptor(list)
    }

    var binding: ActivityMainBinding? = null
    var presenter: MainPresenter? = null
    var bannerAdaptor: BannerAdaptor? = null
    var recipeAdaptor: RecipeAdadptor? = null
    var imgeList = ArrayList<Int>()
    override fun setBannerAdaptor(list: ArrayList<BannerList>) {
        bannerAdaptor = BannerAdaptor(this, list)

        binding!!.bannerRecy.run {

            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = bannerAdaptor
            bannerAdaptor!!.notifyDataSetChanged()
        }

    }

    override fun setRecipeAdaptor(list: ArrayList<RecipeList>) {
        recipeAdaptor = RecipeAdadptor(this, list)

        binding!!.recipeRecy.run {

            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = recipeAdaptor
            recipeAdaptor!!.notifyDataSetChanged()
        }
    }

    fun AddImagesUrlOnline() {

        HashMapForURL = HashMap()

        HashMapForURL!!["CupCake"] = "http://androidblog.esy.es/images/cupcake-1.png"
        HashMapForURL!!["Donut"] = "http://androidblog.esy.es/images/donut-2.png"
        HashMapForURL!!["Eclair"] = "http://androidblog.esy.es/images/eclair-3.png"
        HashMapForURL!!["Froyo"] = "http://androidblog.esy.es/images/froyo-4.png"
        HashMapForURL!!["GingerBread"] = "http://androidblog.esy.es/images/gingerbread-5.png"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter = MainPresenter(this, this)
        presenter?.getData()

       //AddImagesUrlOnline()

            }
}

