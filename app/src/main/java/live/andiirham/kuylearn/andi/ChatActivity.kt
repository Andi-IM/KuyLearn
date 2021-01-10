package live.andiirham.kuylearn.andi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.chats)

        Glide.with(applicationContext)
            .load(ContextCompat.getDrawable(baseContext, R.drawable.ic_arung))
            .apply(RequestOptions().override(80, 80))
            .into(binding.civChatArung)

        Glide.with(applicationContext)
            .load(ContextCompat.getDrawable(baseContext, R.drawable.ic_groups))
            .apply(RequestOptions().override(80, 80))
            .into(binding.civPdga)

        binding.cvArung.setOnClickListener {
            startActivity(Intent(this, ChatRoomActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}