package live.andiirham.kuylearn.hakkan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.andi.ExploreActivity
import live.andiirham.kuylearn.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(applicationContext)
            .load(R.drawable.ic_arung)
            .into(binding.profileImage)

        binding.btnTimeline.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, ExploreActivity::class.java))
        }
    }
}