package com.example.roomassignment.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomassignment.room.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun  selectAllNotes():LiveData<List<NoteEntity>>

    @Insert
    fun InsertNotes(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)
}