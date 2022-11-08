package com.muiedhossain.noteapp20.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.muiedhossain.noteapp20.Dao.NoteDao;
import com.muiedhossain.noteapp20.Database.NoteDatabase;
import com.muiedhossain.noteapp20.Model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDatabase noteDatabase;
    private NoteDao noteDao;
    private LiveData<List<Note>> notelist;

    public NoteRepository(Application application)
    {
        noteDatabase = NoteDatabase.getDatabaseInstance(application);
        noteDao = noteDatabase.noteDao();
        notelist = noteDao.getAllData();//noteDao class e ache
    }

    public void insertNote(Note note)
    {
        new InsertTask(noteDao).execute(note);
    }
    public void deleteNote(Note note)
    {
        new DeleteTask(noteDao).execute(note);
    }
    public  void updateNote(Note note)
    {
        new UpdateTask(noteDao).execute(note);
    }
    public LiveData<List<Note>> getAllData(){ return notelist; };

    private static class InsertTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        public InsertTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNotes(notes[0]);
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        public DeleteTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.deleteNotes(notes[0]);
            return null;
        }
    }

    private static class UpdateTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        public UpdateTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.updateNotes(notes[0]);
            return null;
        }
    }

}
