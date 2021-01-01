package live.andiirham.kuylearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import live.andiirham.kuylearn.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            // intent menuju halaman spesifik
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java)) // nanti diarahkan ke halaman tertentu
            finish()
        }, 2000)
    }
}