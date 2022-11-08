package com.muiedhossain.noteapp20.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.muiedhossain.noteapp20.MainActivity;
import com.muiedhossain.noteapp20.databinding.ActivityInsertNoteBinding;

public class InsertNoteActivity extends AppCompatActivity {

    ActivityInsertNoteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        String typeGet = getIntent().getStringExtra("type");
        if (typeGet.equals("update"))
        {
            setTitle("Update Your Note");
            binding.title.setText(getIntent().getStringExtra("title"));
            binding.noteET.setText(getIntent().getStringExtra("note"));
           int id = getIntent().getIntExtra("id",0);
           binding.saveNotesBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent();
                   intent.putExtra("title", binding.title.getText().toString());
                   intent.putExtra("note", binding.noteET.getText().toString());
                   intent.putExtra("id",id);
                   setResult(RESULT_OK, intent);
                   finish();
               }
           });


        }else {

            setTitle("Add Your Note");
            binding.saveNotesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (binding.title.getText().toString().equals("") || binding.noteET.getText().toString().equals(""))
                    {
                        Toast.makeText(InsertNoteActivity.this, "Cant be empty", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("title", binding.title.getText().toString());
                        intent.putExtra("note", binding.noteET.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            });

        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(InsertNoteActivity.this, MainActivity.class));
    }
}