package com.sendabouquet.swapi_express

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.sendabouquet.swapi_express.adapters.StarAdapter
import com.sendabouquet.swapi_express.data.Star
import com.sendabouquet.swapi_express.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var list = ArrayList<Star>()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // do something here
        binding.rVStar.adapter = StarAdapter(getStar())
        binding.rVStar.layoutManager = LinearLayoutManager(this)
    }

    fun getStar(): ArrayList<Star> {
        var listStar = ArrayList<Star>()
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataSecondary = resources.getStringArray(R.array.data_secondary)
        val dataSupport = resources.getStringArray(R.array.data_support)
        val dataImage = resources.getStringArray(R.array.data_image)
        for (i in dataTitle.indices) {
            val star = Star(dataTitle[i], dataSecondary[i], dataSupport[i], dataImage[i])
            listStar.add(star)
        }

        return listStar
    }

}