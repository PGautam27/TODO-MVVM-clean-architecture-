package com.example.todokt.feature_note.domain.use_case

import com.example.todokt.feature_note.domain.model.Note
import com.example.todokt.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>>{

    }
}