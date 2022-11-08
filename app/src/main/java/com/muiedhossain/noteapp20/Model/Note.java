package com.muiedhossain.noteapp20.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "my_notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id;

    private String title, noteET;

    public Note(String title, String noteET) {
        this.title = title;
        this.noteET = noteET;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteET() {
        return noteET;
    }

    public void setNoteET(String noteET) {
        this.noteET = noteET;
    }


}