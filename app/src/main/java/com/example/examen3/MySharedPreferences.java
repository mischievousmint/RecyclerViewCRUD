package com.example.examen3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MySharedPreferences {

    private static SharedPreferences mySharedPref;
    static final String KEYNAME = "note";
    private static Object listNotes;

    private MySharedPreferences() {

    }

    public static void  init (Context context) {
        if(mySharedPref == null) {
            mySharedPref = context.getSharedPreferences("MYPREFS", Activity.MODE_PRIVATE); //MYPREFS es el nombre del a BBDD
        }
    }

    public static void  saveNote(List<NotesModel> listNotes) {
        SharedPreferences.Editor prefsEditor = mySharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listNotes);
        prefsEditor.putString(KEYNAME, json);
        prefsEditor.apply();
    }

    public static List<NotesModel> loadNote() {
        Gson gson = new Gson();
        String retrieveNote = mySharedPref.getString("MYNOTES", "");
        Type typeNote = new TypeToken<List<NotesModel>>(){}.getType();
        List<NotesModel> listNotes = gson.fromJson(retrieveNote, typeNote);

        return listNotes;

    }
}
