package live.andiirham.kuylearn.hakkan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftar.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}