package com.example.examen3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnMove, btnDel;
    RecyclerView rvNotes;
    List<NotesModel> listNotes;
    NotesAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnMove = findViewById(R.id.btnMove);
        btnDel = findViewById(R.id.btnDel);
        rvNotes = findViewById(R.id.rvNotes);

        btnAdd.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        btnDel.setOnClickListener(this);


        listNotes = getNotes();

        rvNotes.setLayoutManager(new LinearLayoutManager((getApplicationContext())));
        myAdapter = new NotesAdapter(listNotes);
        rvNotes.setAdapter(myAdapter);

    }

    public void  addNote(String title, String body) {
        NotesModel newNote = new NotesModel();
        newNote.setTitle(title);
        newNote.setBody(body);
        listNotes.add(newNote);
        myAdapter.notifyItemInserted(listNotes.size());
    }

    public void onClick(View v) {
    int aver = v.getId();
        switch (aver) {
            case R.id.btnAdd:
                addNote("new note", "new body" );
                Toast.makeText(getApplicationContext(),"hola soy btnAdd", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnMove:
                Toast.makeText(getApplicationContext(),"hola soy btnMove", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDel:
                Toast.makeText(getApplicationContext(),"hola soy btnDel", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

    }

    private List<NotesModel> getNotes(){

        NotesModel note1 = new NotesModel();
        note1.setTitle("Dentista");
        note1.setBody("Dentix a las 17h");

        NotesModel note2 = new NotesModel();
        note2.setTitle("Cena");
        note2.setBody("Vips Sol a las 18h");

        NotesModel note3 = new NotesModel();
        note3.setTitle("Clase");
        note3.setBody("Getafe a las 16h");

        List<NotesModel> listNotes = new ArrayList<>();
        listNotes.add(note1);
        listNotes.add(note2);
        listNotes.add(note3);

        return listNotes;
    }
}
