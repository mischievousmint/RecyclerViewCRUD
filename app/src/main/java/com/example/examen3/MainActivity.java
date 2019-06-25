package com.example.examen3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.helper.ItemTouchHelper.Callback.makeMovementFlags;
import static com.example.examen3.MySharedPreferences.saveNote;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnMove, btnDel, btnAddNote;
    RecyclerView rvNotes;
    static List<NotesModel> listNotes;
    NotesAdapter myAdapter;
    EditText etTitle, etBody;
    String newTitle;
    String newBody;

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

/*    public void openDialog() {
        final Dialog dialog = new Dialog(getApplicationContext()); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_note);
        newTitle = etTitle.getText().toString();
        newBody = etBody.getText().toString();
        // dialog.setTitle(R.string.dialog_title);
        dialog.show();
    }*/


    public AlertDialog createAddDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_note,null);


        etTitle = v.findViewById(R.id.etTitle);
        etBody = v.findViewById(R.id.etBody);
        btnAddNote = v.findViewById(R.id.btnAddNote);

        builder.setView(v);
/*
        newTitle = etTitle.getText().toString();
        newBody = etBody.getText().toString();

        btnAddNote.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       saveNote(listNotes);
                    }
                }
        );*/

        return builder.create();
    }



    public void  addNote(String newTitle, String newBody) {
        NotesModel newNote = new NotesModel();
        createAddDialogo();
        //openDialog();
        newNote.setTitle(newTitle);
        newNote.setBody(newBody);
        listNotes.add(newNote);
        myAdapter.notifyItemInserted(listNotes.size());
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
                addNote("new note", "new body" );
                Toast.makeText(getApplicationContext(),"Hello I am btnAdd", Toast.LENGTH_LONG).show();
                createAddDialogo();
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
