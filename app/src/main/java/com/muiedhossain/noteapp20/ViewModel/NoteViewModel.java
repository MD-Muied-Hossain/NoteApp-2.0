package com.muiedhossain.noteapp20.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.muiedhossain.noteapp20.Model.Note;
import com.muiedhossain.noteapp20.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> notelist;

    public NoteViewModel(@NonNull Application application)
    {
        super(application);
        noteRepository = new NoteRepository(application);
        notelist = noteRepository.getAllData();
    }
    public void insert(Note note)
    {
        noteRepository.insertNote(note);
    }
    public void update(Note note)
    {
        noteRepository.updateNote(note);
    }
    public void delete(Note note)
    {
        noteRepository.deleteNote(note);
    }
    public LiveData<List<Note>> getAllNotes()
    {
        return notelist;
    }
}
