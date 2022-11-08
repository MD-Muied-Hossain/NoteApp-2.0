package com.muiedhossain.noteapp20.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;

import com.muiedhossain.noteapp20.Model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM my_notes")
    public LiveData<List<Note>> getAllData();

    @Insert
    void insertNotes(Note note);

    @Update
    void updateNotes(Note note);

    @Delete
    void deleteNotes(Note note);
}
