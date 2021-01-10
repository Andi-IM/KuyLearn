package live.andiirham.kuylearn.raven

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}