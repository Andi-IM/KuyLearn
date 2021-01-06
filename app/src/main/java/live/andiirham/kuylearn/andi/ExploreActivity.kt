package live.andiirham.kuylearn.andi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import live.andiirham.kuylearn.R
import live.andiirham.kuylearn.andi.adapter.PostAdapter
import live.andiirham.kuylearn.andi.dataclass.Posts
import live.andiirham.kuylearn.databinding.ActivityExploreBinding

class ExploreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding
    private val list = ArrayList<Posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPosts.setHasFixedSize(true)
        list.addAll(getList())

        showPosts()
    }

    private fun getList(): Collection<Posts> {
        val name = resources.getString(R.string.item_user_name)
        val company = resources.getString(R.string.item_user_company)
        val time = resources.getString(R.string.item_user_time)
        val message = resources.getString(R.string.item_user_message)
        val photo = ResourcesCompat.getDrawable(resources, R.drawable.ic_arung, null).toString()

        for (i in 1..5) {
            val post = Posts(
                name,
                company,
                time,
                message,
                photo
            )
            list.add(post)
        }
        return list
    }

    private fun showPosts() {
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = PostAdapter(list)
        binding.rvPosts.adapter = cardViewAdapter
    }
}