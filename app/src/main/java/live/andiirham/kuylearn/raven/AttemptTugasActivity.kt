package live.andiirham.kuylearn.raven

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.databinding.ActivityAttemptTugasBinding

class AttemptTugasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAttemptTugasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttemptTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}