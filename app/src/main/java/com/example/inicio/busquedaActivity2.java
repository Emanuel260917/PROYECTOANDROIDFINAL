package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inicio.databinding.ActivityBusqueda2Binding;
import com.example.inicio.databinding.ActivityRegistroBinding;

public class busquedaActivity2 extends AppCompatActivity {

    private ActivityBusqueda2Binding busqueda2Binding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        busqueda2Binding = ActivityBusqueda2Binding.inflate(getLayoutInflater());
        View view = busqueda2Binding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
    }


    public void busqueda2(View view ){
        if(busqueda2Binding.etnomb.getText().toString().isEmpty()){
            Toast.makeText(this,"debes ingresar el nombre del producto que deseas buacar", Toast.LENGTH_SHORT).show();

        }
        else {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            String nombre = busqueda2Binding.etnomb.getText().toString();
            Cursor cursor = db.rawQuery("SELECT * FROM producto WHERE nombre = '"+ nombre + "'",null);
            cursor.moveToNext();
            busqueda2Binding.tvid.setText("id: "+ cursor.getInt(0));
            busqueda2Binding.etnom.setText("nombre: "+ cursor.getString(1));
            busqueda2Binding.etpre.setText("precio: "+ cursor.getFloat(2));
            busqueda2Binding.etdescrip.setText("descripcion: "+ cursor.getString(3));
            busqueda2Binding.etref.setText("referencia: "+ cursor.getString(4));
            busqueda2Binding.etcant.setText("cantidad: "+ cursor.getString(5));
            busqueda2Binding.etcate.setText("categoria: "+ cursor.getString(6));
        }

    }
    public void regresar(View view){
        Intent intent = new Intent(this, ProductoActivity.class);
        startActivity(intent);
    }
}