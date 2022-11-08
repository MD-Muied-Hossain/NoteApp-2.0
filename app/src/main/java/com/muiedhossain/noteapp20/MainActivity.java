package com.muiedhossain.noteapp20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.muiedhossain.noteapp20.Activity.InsertNoteActivity;
import com.muiedhossain.noteapp20.Activity.UpdateNoteActivity;
import com.muiedhossain.noteapp20.Adapter.RVAdapter;
import com.muiedhossain.noteapp20.Model.Note;
import com.muiedhossain.noteapp20.ViewModel.NoteViewModel;
import com.muiedhossain.noteapp20.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding binding;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        noteViewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NoteViewModel.class);

        binding.addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertNoteActivity.class);

                intent.putExtra("type","addMode");
                //InsertNote theke result ta intent e bind hoy ei methode e asbe
                //tai nicher onActivity Result ta theke nite hoy
                startActivityForResult(intent,1);
            }
        });

        binding.itemRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.itemRecyclerView.setHasFixedSize(true);

        RVAdapter adapter = new RVAdapter();
        binding.itemRecyclerView.setAdapter(adapter);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.submitList(notes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction == ItemTouchHelper.RIGHT)
                {
                    noteViewModel.delete(adapter.getNote(viewHolder.getAbsoluteAdapterPosition()));
                    Toast.makeText(MainActivity.this, "Note Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else if(direction == ItemTouchHelper.LEFT) {
                    Intent intent = new Intent(MainActivity.this,InsertNoteActivity.class);
                    intent.putExtra("type","update");
                    intent.putExtra("title",adapter.getNote(viewHolder.getAdapterPosition()).getTitle());
                    intent.putExtra("note",adapter.getNote(viewHolder.getAdapterPosition()).getNoteET());
                    intent.putExtra("id",adapter.getNote(viewHolder.getAdapterPosition()).getId());
                    startActivityForResult(intent,2);
                }
            }
        }).attachToRecyclerView(binding.itemRecyclerView);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1){
            String title = data.getStringExtra("title");
            String noteBody = data.getStringExtra("note");

            Note note = new Note(title,noteBody);
            noteViewModel.insert(note);

            Toast.makeText(this, "Note Created", Toast.LENGTH_SHORT).show();

        }
        else if (requestCode == 2){
            String title = data.getStringExtra("title");
            String noteBody = data.getStringExtra("note");
            Note note = new Note(title,noteBody);
            note.setId(data.getIntExtra("id",0));
            noteViewModel.update(note);
            Toast.makeText(this, "Note Updated", Toast.LENGTH_SHORT).show();

        }



    }
   /* @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(this, UpdateNoteActivity.class);
        intent.putExtra("title","update);
        intent.putExtra("note",RVAdapter.class);
        startActivity(intent);
    }*/

}