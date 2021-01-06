package live.andiirham.kuylearn.andi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import live.andiirham.kuylearn.andi.dataclass.Posts
import live.andiirham.kuylearn.databinding.ItemCardviewExploreBinding

class PostAdapter(private val list: ArrayList<Posts>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCardviewExploreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(posts: Posts) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(posts.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(binding.civExplore)
                binding.txtName.text = posts.name
                binding.txtCompany.text = posts.company
                binding.txtTime.text = posts.date
                binding.txtMessage.text = posts.message
                Glide.with(itemView.context)
                    .load(posts.photo)
                    .into(binding.postImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCardviewExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
