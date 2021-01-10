package live.andiirham.kuylearn.andi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        Glide.with(applicationContext)
            .load(ContextCompat.getDrawable(baseContext, R.drawable.ic_arung))
            .apply(RequestOptions().override(80, 80))
            .into(binding.civProfilePhoto)
    }
}