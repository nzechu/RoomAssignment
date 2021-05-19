package com.example.roomassignment.room.entities

import android.content.Context
import android.provider.Settings
import androidx.lifecycle.LiveData
import com.example.roomassignment.room.db.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteRepository(context: Context) {
    private val db =NoteDatabase.invoke(context)

    fun  getAllNotes():LiveData<List<NoteEntity>> = db.noteDao().selectAllNotes()
    fun insertNote(noteEntity: NoteEntity){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.noteDao().InsertNotes(noteEntity)
            }
        }
    }

}