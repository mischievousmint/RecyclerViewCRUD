package com.example.examen3;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.examen3.MySharedPreferences.saveNote;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnMove, btnDel, btnAddNote;
    RecyclerView rvNotes;
    static List<NotesModel> listNotes;
    NotesAdapter myAdapter;
    EditText etTitle, etBody;
    String newTitle;
    String newBody;
    Dialog createAddDialog;

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
        //btnAddNote.setOnClickListener(this);


        listNotes = getNotes();

        rvNotes.setLayoutManager(new LinearLayoutManager((getApplicationContext())));
        myAdapter = new NotesAdapter(listNotes);
        rvNotes.setAdapter(myAdapter);

    }



    public void createAddDialog() {
        createAddDialog = new Dialog(this);
        createAddDialog.setContentView(R.layout.dialog_note);

        etTitle = createAddDialog.findViewById(R.id.etTitle);
        etBody = createAddDialog.findViewById(R.id.etBody);
        btnAddNote = createAddDialog.findViewById(R.id.btnAddNote);

        btnAddNote.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newTitle = etTitle.getText().toString();
                        newBody = etBody.getText().toString();
                        addNote(newTitle, newBody );
                        createAddDialog.dismiss();
                    }
                }
        );

        createAddDialog.show();

    }



    public void  addNote(String newTitle, String newBody) {
        NotesModel newNote = new NotesModel();
        newNote.setTitle(newTitle);
        newNote.setBody(newBody);
        listNotes.add(newNote);
        myAdapter.notifyItemInserted(listNotes.size());
        saveNote(listNotes);
    }

    public void  delNote() {
        listNotes.remove(listNotes.size()-1);
        myAdapter.notifyItemRemoved(listNotes.size());
    }

/*
    public void moveNote() {
        listNotes.swap;
        notifyItemMoved();
    }
*/
    public void onClick(View v) {
    int aver = v.getId();
        switch (aver) {
            case R.id.btnAdd:
                Toast.makeText(getApplicationContext(),"Hello I am btnAdd", Toast.LENGTH_LONG).show();
                createAddDialog();
                break;
            case R.id.btnMove:
                Toast.makeText(getApplicationContext(),"Hello I am btnMove", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDel:
                delNote();
                Toast.makeText(getApplicationContext(),"Hello I am btnDel", Toast.LENGTH_LONG).show();
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
