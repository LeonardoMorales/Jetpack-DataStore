package dev.leonardom.jetpackdatastore.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.leonardom.jetpackdatastore.R
import dev.leonardom.jetpackdatastore.data.Note
import dev.leonardom.jetpackdatastore.data.NotePriority
import dev.leonardom.jetpackdatastore.databinding.NoteItemBinding

class MainAdapter: ListAdapter<Note, MainAdapter.NoteViewHolder>(NoteDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NoteItemBinding.inflate(layoutInflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class NoteViewHolder(
        itemBinding: NoteItemBinding
    ): RecyclerView.ViewHolder(itemBinding.root){

        private val title = itemBinding.textViewTitle
        private val priority = itemBinding.textViewPriority
        private val finished = itemBinding.imageViewFinished
        private val viewPriority = itemBinding.viewPriority

        fun bind(note: Note) = with(itemView){
            title.text = note.title


            finished.setImageDrawable(
                if(note.completed){
                    ContextCompat.getDrawable(itemView.context, R.drawable.ic_check)
                } else {
                    ContextCompat.getDrawable(itemView.context, R.drawable.ic_uncheck)
                }
            )

            priority.text = note.priority.name

            when(note.priority){
                NotePriority.LOW -> {
                    priority.setTextColor(ContextCompat.getColor(itemView.context, R.color.notePriorityLowColor))
                    viewPriority.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.notePriorityLowColor))
                }
                NotePriority.MEDIUM -> {
                    priority.setTextColor(ContextCompat.getColor(itemView.context, R.color.notePriorityMediumColor))
                    viewPriority.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.notePriorityMediumColor))
                }
                NotePriority.HIGH -> {
                    priority.setTextColor(ContextCompat.getColor(itemView.context, R.color.notePriorityHighColor))
                    viewPriority.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.notePriorityHighColor))
                }
            }

        }

    }

}

class NoteDiffCallback: DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}