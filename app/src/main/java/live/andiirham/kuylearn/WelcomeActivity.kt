package live.andiirham.kuylearn

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import live.andiirham.kuylearn.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private val dots: Array<TextView> = TODO()
    private var prefManager: PrefManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        if(!prefManager.isFirstTimeLaunch){
            launchHomeScreen()
            finish()
        }

        // membuat notif transparan
        if (Build.VERSION.SDK_INT >= 21){
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        }

        setContentView(binding.root)

        var layouts = intArrayOf(
            R.layout.slide1,
            R.layout.slide2,
            R.layout.slide3,
            R.layout.slide4)

        // tombol dots (lingkaran kecil perpindahan slide)
    }

    private fun launchHomeScreen() {

    }
}