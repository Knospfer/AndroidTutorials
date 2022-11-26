package com.mberrueta.a14_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        var todoList = mutableListOf(Todo("Aaaaaaaaa", true), Todo("BEEEEEE", false))

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager =
            LinearLayoutManager(this) //questo decide come si ricostruiscono le cose

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val etTodo = findViewById<EditText>(R.id.etTodo)
        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)

            todoList.add(todo)
            //devo aggiornare la recyclerView a mano
            //adapter.notifyDataSetChanged() //funziona ma poco efficiente perchè aggiorna tutto
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}