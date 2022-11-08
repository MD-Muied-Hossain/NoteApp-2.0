package com.muiedhossain.noteapp20.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.muiedhossain.noteapp20.Model.Note;
import com.muiedhossain.noteapp20.R;
import com.muiedhossain.noteapp20.databinding.ItemRvBinding;

public class RVAdapter extends ListAdapter<Note,RVAdapter.ViewHolder> {

    public RVAdapter(){
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getNoteET().equals(newItem.getNoteET());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = getNote(position);
        holder.binding.titleRV.setText(note.getTitle());
        holder.binding.noteRV.setText(note.getNoteET());
    }
    public Note getNote(int position){
        return getItem(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRvBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemRvBinding.bind(itemView);
        }
    }
}
