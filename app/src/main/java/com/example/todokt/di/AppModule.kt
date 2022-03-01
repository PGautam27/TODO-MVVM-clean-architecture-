package com.example.todokt.di

import android.app.Application
import androidx.room.Room
import com.example.todokt.feature_note.data.data_Source.NoteDataBase
import com.example.todokt.feature_note.data.repository.NoteRepositoryImp
import com.example.todokt.feature_note.domain.repository.NoteRepository
import com.example.todokt.feature_note.domain.use_case.DeleteNote
import com.example.todokt.feature_note.domain.use_case.GetNotes
import com.example.todokt.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provedNoteRepository(db: NoteDataBase):NoteRepository{
        return NoteRepositoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNotUseCases(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}