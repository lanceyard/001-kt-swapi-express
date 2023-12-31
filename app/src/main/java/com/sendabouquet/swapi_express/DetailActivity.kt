package com.sendabouquet.swapi_express

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import coil.load
import com.sendabouquet.swapi_express.data.Star
import com.sendabouquet.swapi_express.databinding.ActivityDetailBinding
import com.sendabouquet.swapi_express.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        val detail = "DETAIL"
    }

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityDetailBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataChar = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(detail, Star::class.java)
        } else {
            intent.getParcelableExtra(detail)
        }

        binding.topAppBar.title = dataChar!!.title
        binding.tvTitle.text = dataChar!!.title
        binding.tvSecondary.text = dataChar!!.secondary
        binding.tvSupport.text = dataChar!!.support
        binding.ivStar.load(dataChar!!.photo) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_connection_error)
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.action_share -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.setType("text/plain")
                    intent.putExtra(Intent.EXTRA_TEXT, "do you like ${dataChar!!.title} bro? kalo suka sini aku kasi tau hehe")
                    startActivity(Intent.createChooser(intent, "Share gan xixixi"))
                    true
                }
                else -> false
            }
        }
    }
}