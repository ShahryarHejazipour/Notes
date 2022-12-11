package com.tispunshahryar960103.notes.di

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.tispunshahryar960103.notes.data.AppDatabase
import com.tispunshahryar960103.notes.data.NoteDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext appContext:Context):AppDatabase{

        return Room.databaseBuilder(appContext,AppDatabase::class.java, "note_db")
            .allowMainThreadQueries()
            .build()

    }

    @Singleton
    @Provides
    fun getNoteDAO(db : AppDatabase) = db.noteDAO()




}