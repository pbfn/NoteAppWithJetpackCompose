package com.pedro_bruno.noteappcompose.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.pedro_bruno.noteappcompose.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM tblNotes")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM tblNotes WHERE id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM tblNotes ")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)

}