package com.example.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationcontentproviderclient.adapter.ClientAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var notesRecycler: RecyclerView
    lateinit var notesRefreshButton: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRefreshButton = findViewById(R.id.client_button_refresh)
        notesRecycler = findViewById(R.id.client_list)
        getContentProvider()

        notesRefreshButton.setOnClickListener {
            getContentProvider()

        }
    }
    // vamos criar um método que vai ser responsável por fazer a consulta no contentProvider  da nossa aplicação anterior
    private fun getContentProvider(){
        try {
            val url = "content://com.example.contentprovider.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? = contentResolver.query(data,null,null,null,"title")
            notesRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)

            }

        }catch (exception: Exception){
            exception.printStackTrace()
        }
    }
}