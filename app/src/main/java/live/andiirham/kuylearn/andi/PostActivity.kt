package live.andiirham.kuylearn.andi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_comment.*
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.explore)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(applicationContext)
            .load(ResourcesCompat.getDrawable(resources, R.drawable.ic_arung, null))
            .into(binding.circleImageView)

        Glide.with(applicationContext)
            .load(ResourcesCompat.getDrawable(resources, R.drawable.ic_arung, null))
            .into(civ_comment)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}