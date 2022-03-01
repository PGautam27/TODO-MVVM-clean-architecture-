package com.example.todokt.feature_note.data.data_Source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todokt.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase:RoomDatabase() {
    abstract val noteDao:NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}