package com.pedro_bruno.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pedro_bruno.noteappcompose.model.Note
import com.pedro_bruno.noteappcompose.util.DateConverter
import com.pedro_bruno.noteappcompose.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao

}