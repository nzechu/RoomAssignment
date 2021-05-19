package com.example.roomassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomassignment.room.adapter.NoteAdapter
import com.example.roomassignment.room.entities.NoteEntity
import com.example.roomassignment.room.entities.NoteRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteBtn:FloatingActionButton
    private lateinit var noteRepository: NoteRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        insertDataIntoDb()
    }
    private fun init(){
        noteAdapter= NoteAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView=findViewById(R.id.recyclerView)
        addNoteBtn=findViewById(R.id.floatingActionButton)
        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager=linearLayoutManager
        noteRepository= NoteRepository(this)
        noteRepository.getAllNotes().observe(this,{notes ->
            noteAdapter.submitList(notes)

        })

    }
    private fun insertDataIntoDb(){
        val noteEntity = NoteEntity(title = "Hey", description = "Hi, How are you")
        noteRepository.insertNote(noteEntity)

    }
}