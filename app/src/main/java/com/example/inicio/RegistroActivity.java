package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inicio.databinding.ActivityMainBinding;
import com.example.inicio.databinding.ActivityRegistroBinding;

import java.security.Key;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding registroBinding;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registroBinding = ActivityRegistroBinding.inflate(getLayoutInflater());
        View view = registroBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);

    }
    public void registroUser(View view ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String name = registroBinding.etnombre.getText().toString();
        String apellido = registroBinding.etapellido.getText().toString();
        String Email = registroBinding.etEMAIL.getText().toString();
        String password = registroBinding.etpassword.getText().toString();
        userData.put("name",name);
        userData.put("apellido",apellido);
        userData.put("Email",Email);
        userData.put("password",password);

        long newUser = db.insert("users",null,userData);
        Toast.makeText(this, ""+ newUser, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}