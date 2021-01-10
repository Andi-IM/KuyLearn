package live.andiirham.kuylearn.raven.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import live.andiirham.kuylearn.databinding.ItemClassListBinding
import live.andiirham.kuylearn.raven.dataclass.ClassModel


class ClassAdapter(private val list: ArrayList<ClassModel>) :
    RecyclerView.Adapter<ClassAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemClassListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(classes: ClassModel) {
            Glide.with(itemView.context)
                .load(classes.teacherPhoto)
                .apply(RequestOptions().override(55, 55))
                .into(binding.teacherPhoto)
            Glide.with(itemView.context)
                .load(classes.backgroundPhoto)
                .into(binding.backgroundPhoto)
            binding.classNames.text = classes.className
            binding.lecturer.text = classes.teacher
            binding.secondLecturer.text = classes.secondTeacher
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(classes) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemClassListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ClassModel)
    }
}