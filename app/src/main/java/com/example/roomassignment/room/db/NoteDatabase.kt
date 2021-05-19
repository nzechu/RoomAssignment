package com.example.roomassignment.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomassignment.room.dao.NoteDao
import com.example.roomassignment.room.entities.NoteEntity


@Database(
        entities = [NoteEntity::class],
        version = 1
)
abstract class NoteDatabase : RoomDatabase(){
    abstract  fun noteDao():NoteDao

    companion object{
        @Volatile private  var instance:NoteDatabase?=null
        private var LOCK=Any()

        operator  fun invoke (context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context)
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(context, NoteDatabase::class.java, "note.db").build()
    }
}