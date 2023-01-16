package com.crudandroid.user.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class conexao extends SQLiteOpenHelper {
    // faz a interacao com banco de dados
    private static SQLiteDatabase instance;

    public static SQLiteDatabase getInstance() {
        return instance;
    }

    public conexao(Context context, String name,
                   SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase(); // captura a instancia
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabelaUsuario = "";
        tabelaUsuario += " create table usuario ( ";
        tabelaUsuario += " id integer primary key autoincrement, ";
        tabelaUsuario += " nome varchar(255), ";
        tabelaUsuario += " login varchar(255), ";
        tabelaUsuario += " senha varchar(255) ";
        tabelaUsuario += " ); ";

        sqLiteDatabase.execSQL(tabelaUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
