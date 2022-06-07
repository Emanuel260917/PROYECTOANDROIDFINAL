package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inicio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail, etPassword;
    private Button btnsignin, btnsignup;
    private TextView tvForgotpassword;
    private ActivityMainBinding mainBinding;
    private DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        /*etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById( R.id.etPassword);
        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        tvForgotpassword = findViewById(R.id.tvforgotpassword);*/
        mainBinding.btnsignin.setOnClickListener(this);
        mainBinding.btnsignup.setOnClickListener(this);
         //Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
        //startActivity(intent);
        dbHelper = new DbHelper(this);

    }
    public void ShowMessage(){
        Intent intent = new Intent(this,ProductoActivity.class);
        startActivity(intent);
        Toast.makeText(this, "HOLA MUNDO", Toast.LENGTH_SHORT).show();
    }
    public void goToRegister(){
        Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
        startActivity(intent);
    }
    public void signin(View view){
        if(etEmail.getText().toString().isEmpty() && etPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
        else {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String sql = String.format("SELECT * FROM users WHERE Email=" + etEmail.getText().toString());
            Cursor cursor = db.rawQuery(sql,null);
            if (cursor.getCount() > 0){
                Toast.makeText(this,"usuario correcto", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this,"El usuario no existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnsignin:
                ShowMessage();
                break;
            case R.id.btnsignup:
                goToRegister();
                break;
    }
}
}