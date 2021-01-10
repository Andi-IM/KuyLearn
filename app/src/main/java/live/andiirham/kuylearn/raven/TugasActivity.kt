package live.andiirham.kuylearn.raven

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.databinding.ActivityTugasBinding
import live.andiirham.kuylearn.raven.adapter.TugasAdapter
import live.andiirham.kuylearn.raven.dataclass.Tugas

class TugasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTugasBinding
    private val list = ArrayList<Tugas>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(applicationContext, R.color.base_color))
        )

        binding.rvTugas.setHasFixedSize(true)
        getList()
        showTugas()
    }

    private fun getList(): ArrayList<Tugas> {
        val tugas = arrayOf("UAS RPL 2 AAssignment")
        val deadline = arrayOf("1 day 13 hours")

        for (position in tugas.indices) {
            val model = Tugas(
                tugas[position],
                deadline[position]
            )
            list.add(model)
        }
        return list
    }

    private fun showTugas() {
        binding.rvTugas.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = TugasAdapter(list)
        binding.rvTugas.adapter = cardViewAdapter

        cardViewAdapter.setOnItemClickCallback(object : TugasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tugas) {
                startActivity(Intent(this@TugasActivity, AttemptTugasActivity::class.java))
            }
        })
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