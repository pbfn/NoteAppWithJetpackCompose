package com.pedro_bruno.noteappcompose.data

import com.pedro_bruno.noteappcompose.model.Note

class NotesDataSource{
    fun loadNotes(): List<Note>{
        return listOf(
            Note(title ="Nota 1" , description = "Descrição nota 1"),
            Note(title ="Nota 2" , description = "Descrição nota 2"),
            Note(title ="Nota 3" , description = "Descrição nota 3"),
            Note(title ="Nota 4" , description = "Descrição nota 4"),
            Note(title ="Nota 5" , description = "Descrição nota 5"),
            Note(title ="Nota 6" , description = "Descrição nota 6"),
            Note(title ="Nota 7" , description = "Descrição nota 7"),
            Note(title ="Nota 8" , description = "Descrição nota 8"),
            Note(title ="Nota 9" , description = "Descrição nota 9"),
        )
    }
}