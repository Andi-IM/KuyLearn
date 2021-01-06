package live.andiirham.kuylearn.hakkan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.databinding.ActivitySpashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            // intent menuju halaman spesifik
            startActivity(
                Intent(
                    this@SplashScreenActivity,
                    WelcomeActivity::class.java
                )
            ) // nanti diarahkan ke halaman tertentu
            finish()
        }, 2000)
    }
}