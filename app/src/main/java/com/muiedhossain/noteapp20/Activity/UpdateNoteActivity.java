package com.muiedhossain.noteapp20.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.muiedhossain.noteapp20.databinding.ActivityUpdateNoteBinding;

public class UpdateNoteActivity extends AppCompatActivity {

    ActivityUpdateNoteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       /* String title = getIntent().getStringExtra("title");
        String noteBody = getIntent().getStringExtra("note");
        setTitle("Update Your Note");*/

     /*   binding.upTitle.setText(title);
        binding.upNoteET.setText(noteBody);*/

       /* binding.upNoteET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("title", binding.upTitle.getText().toString());
                intent.putExtra("note", binding.upNoteET.getText().toString());
                setResult(RESULT_OK, intent);
                finish();


            }
        });*/



    }
}