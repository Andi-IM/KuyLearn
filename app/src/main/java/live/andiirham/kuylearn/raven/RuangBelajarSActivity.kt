package live.andiirham.kuylearn.raven

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityRuangBelajarSiswaBinding

class RuangBelajarSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRuangBelajarSiswaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRuangBelajarSiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = resources.getString(R.string.app_name)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(applicationContext, R.color.base_color))
        )

        binding.btnBelajarTugas.setOnClickListener {
            startActivity(Intent(this, TugasActivity::class.java))
        }

        binding.btnBelajarAbsensi.setOnClickListener {
            startActivity(Intent(this, AbsenActivity::class.java))
        }

        binding.btnBelajarVicon.setOnClickListener {
            startActivity(Intent(this, ViconActivity::class.java))
        }

        binding.btnBelajarKelas.setOnClickListener {
            startActivity(Intent(this, ClassListActivity::class.java))
        }

        binding.btnBelajarQuiz.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

        binding.btnBelajarUjian.setOnClickListener {
            startActivity(Intent(this, UjianActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.kelas_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notification -> {
                startActivity(Intent(this, NotificationActivity::class.java))
            }
        }
        return true
    }
}