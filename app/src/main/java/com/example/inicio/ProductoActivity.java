package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inicio.databinding.ActivityProductoBinding;

import java.text.BreakIterator;

public class ProductoActivity extends AppCompatActivity {
    private ActivityProductoBinding productoBinding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productoBinding = ActivityProductoBinding.inflate(getLayoutInflater());
        View view = productoBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
    }

   public void Producto(View view){
       SQLiteDatabase db = dbHelper.getWritableDatabase();
       ContentValues userData = new ContentValues();
       String nombre = productoBinding.etnombreprod.getText().toString();
       String precio = productoBinding.etprecio.getText().toString();
       String descripcion = productoBinding.etdescripcion.getText().toString();
       String referencia = productoBinding.etreferencia.getText().toString();
       String cantidad = productoBinding.etcantidad.getText().toString();
       String categoria = productoBinding.etcategoria.getText().toString();



       userData.put("nombre",nombre);
       userData.put("precio",precio);
       userData.put("descripcion",descripcion);
       userData.put("referencia",referencia);
       userData.put("cantidad",cantidad);
       userData.put("categoria",categoria);

       long newUser = db.insert("producto",null,userData);
       Toast.makeText(this, ""+ newUser, Toast.LENGTH_SHORT).show();

   }
   public void login(View view){
       Intent intent = new Intent(this,MainActivity.class);
       startActivity(intent);
   }

    public void buscar(View view){
        Intent intent = new Intent(this,busquedaActivity2.class);
        startActivity(intent);
    }
}