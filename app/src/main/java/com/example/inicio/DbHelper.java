package com.example.inicio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final  String DATABASE_NAME ="InicioUno";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL
                ("CREATE TABLE users (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50)," +
                " apellido VARCHAR (30)," +
                " Email VARCHAR (50)," +
                "password VARCHAR(16))");

        sqLiteDatabase.execSQL
                ("CREATE TABLE producto (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "productos VARCHAR(50)," +
                        " ingresar VARCHAR (50)," +
                        "nombre VARCHAR(16))");

        sqLiteDatabase.execSQL
                ("CREATE TABLE busqueda2 (Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre VARCHAR(50)," +
                "precio FLOAT," +
                " descripcion VARCHAR (50)," +
                "referencia VARCHAR(16), " +
                        "cantidad INT," +
                        "categoria VARCHAR(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS producto");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS busqueda2");
        onCreate(sqLiteDatabase);


    }
}
