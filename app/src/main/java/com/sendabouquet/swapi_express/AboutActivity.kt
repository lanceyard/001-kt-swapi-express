package com.sendabouquet.swapi_express

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.sendabouquet.swapi_express.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private var _binding: ActivityAboutBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.profileImage.load("https://avatars.githubusercontent.com/u/12584890?v=4") {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_connection_error)
        }
    }
}