package com.mberrueta.a14_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    //devo guardarmi questa sintassi strana
    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView
        val cbDone: CheckBox

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            cbDone = itemView.findViewById(R.id.cbDone)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //quando mi serve un viewHolder, ossia quando l'utente scrolla e devo creare un nuovo elemento
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        ) // va sempre false nelle recyclerView sennò crasha
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        //quando metto i dati nella lista, holder accede alla view che devo riempire, position è l'indice dell'holder
        holder.itemView.apply {
            val item = todos[position]
            holder.tvTitle.text = item.title
            holder.cbDone.isChecked = item.isChecked
        }
    }

    override fun getItemCount(): Int {
        //mi dice quandi item ho, non ritornare 0
        return todos.size
    }
}