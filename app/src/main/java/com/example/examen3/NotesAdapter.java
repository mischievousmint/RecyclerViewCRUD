package com.example.examen3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {


    private List<NotesModel> NotesModelList; //objetos de la lista de datos

    public NotesAdapter(List<NotesModel> userModelList) { //Constructor
        this.NotesModelList = userModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  //Crea la celda modelo
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = NotesModelList.get(position).getTitle();
        String body = NotesModelList.get(position).getBody();

        holder.title.setText(title);
        holder.body.setText(body);
    }

    @Override
    public int getItemCount() {
        return NotesModelList.size();
    }









    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView body;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tvTitle);
            body = v.findViewById(R.id.tvBody);
        }
    }
}
