package live.andiirham.kuylearn.raven.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import live.andiirham.kuylearn.databinding.ItemRowAssignmentBinding
import live.andiirham.kuylearn.raven.dataclass.Tugas

class TugasAdapter(private val list: ArrayList<Tugas>) :
    RecyclerView.Adapter<TugasAdapter.ViewHolder>() {

    private var onItemClickCallback: TugasAdapter.OnItemClickCallback? = null
    fun setOnItemClickCallback(
        onItemClickCallback: OnItemClickCallback
    ) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: ItemRowAssignmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tugas: Tugas) {
            binding.assignName.text = tugas.namaTugas
            binding.assignDeadline.text = tugas.deadline
            binding.btnAssignSubmit.setOnClickListener { onItemClickCallback?.onItemClicked(tugas) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowAssignmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Tugas)
    }
}