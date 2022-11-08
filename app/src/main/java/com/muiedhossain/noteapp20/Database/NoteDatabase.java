package com.muiedhossain.noteapp20.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.muiedhossain.noteapp20.Dao.NoteDao;
import com.muiedhossain.noteapp20.Model.Note;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
    private static NoteDatabase INSTANCE;

    public static synchronized NoteDatabase getDatabaseInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class
                    ,"my_notes").fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

}
