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
import live.andiirham.kuylearn.databinding.ActivityClassListBinding
import live.andiirham.kuylearn.raven.adapter.ClassAdapter
import live.andiirham.kuylearn.raven.dataclass.ClassModel

class ClassListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClassListBinding
    private val list = ArrayList<ClassModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvClasses.setHasFixedSize(true)
        getlist()
        showClasses()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.kelas)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(applicationContext, R.color.base_color))
        )
    }

    private fun getlist(): ArrayList<ClassModel> {
        val className = arrayOf("Prak Desain Grafis ")
        val lecturer = arrayOf("Bayu Ramadhani Fajri, S. St., M. Ds")
        val secondLecturer = arrayOf("Salman Alfarisi")
        val background = intArrayOf(R.drawable.billingwarnet)
        val photo = intArrayOf(R.drawable.ic_groups)

        for (position in className.indices) {
            val classes = ClassModel(
                className = className[position],
                teacher = lecturer[position],
                backgroundPhoto = background[position],
                teacherPhoto = photo[position],
                secondTeacher = secondLecturer[position]
            )
            list.add(classes)
        }
        return list
    }

    private fun showClasses() {
        binding.rvClasses.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = ClassAdapter(list)
        binding.rvClasses.adapter = cardViewAdapter

        cardViewAdapter.setOnItemClickCallback(object : ClassAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ClassModel) {
                startActivity(Intent(this@ClassListActivity, RuangBelajarSActivity::class.java))
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}