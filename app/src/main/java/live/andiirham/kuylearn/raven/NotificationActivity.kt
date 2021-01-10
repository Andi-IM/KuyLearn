package live.andiirham.kuylearn.raven

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.notification)
    }
}