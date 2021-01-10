package live.andiirham.kuylearn.andi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.andi.adapter.PostAdapter
import live.andiirham.kuylearn.andi.dataclass.Posts
import live.andiirham.kuylearn.databinding.ActivityExploreBinding
import live.andiirham.kuylearn.hakkan.DashboardActivity

class ExploreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding
    private val list = ArrayList<Posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        list.clear()

        binding.rvPosts.setHasFixedSize(true)
        getList()
        showPosts()

        binding.btnDashboard.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }

        binding.btnChats.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        binding.exploreSearch.suggestionsAdapter
        binding.exploreSearch.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
            override fun onSuggestionSelect(position: Int): Boolean {
                return true
            }

            override fun onSuggestionClick(position: Int): Boolean {
                return true
            }

        })
    }

    private fun getList(): ArrayList<Posts> {
        val name = resources.getStringArray(R.array.names)
        val company = resources.getStringArray(R.array.company)
        val time = resources.getStringArray(R.array.messages)
        val message = resources.getStringArray(R.array.messages)
        val photo = resources.obtainTypedArray(R.array.images)

        Log.d(TAG, "NAME INDICES ${name.indices}")

        for (position in name.indices) {
            val post = Posts(
                name[position],
                company[position],
                time[position],
                message[position],
                photo.getResourceId(position, -1)
            )
            list.add(post)
        }
        photo.recycle()
        return list
    }

    private fun showPosts() {
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = PostAdapter(list)
        binding.rvPosts.adapter = cardViewAdapter

        cardViewAdapter.setOnItemClickCallback(object : PostAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Posts) {
                // ONLY INTENT WITHOUT DATA
                startActivity(Intent(this@ExploreActivity, PostActivity::class.java))
            }
        })

    }

    companion object {
        private const val TAG = "ExploreActivity"
    }
}