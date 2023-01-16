package com.crudandroid.user.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crudandroid.user.entity.Usuario;
import com.crudandroid.user.sqlite.conexao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    //metodo salvar

    public void salvar(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("login", usuario.getLogin());
        values.put("senha", usuario.getSenha());

        SQLiteDatabase conSqLiteDatabase = conexao.getInstance();
        conSqLiteDatabase.insert("usuario", null, values);

    }

    public void alterar(Usuario usuario) {

    }

    public List<Usuario> listar() {
        SQLiteDatabase con = conexao.getInstance();

        Cursor c = con.query("usuario", new String[]{"id", "nome", "login", "senha"}, null, null,
                null, null, null, null);

        List<Usuario> usuarios = new ArrayList<Usuario>();


        if (c.moveToFirst()) {
            do {

                Usuario usuario = new Usuario();
                usuario.setId(c.getInt(1));
                usuario.setNome(c.getString(2));
                usuario.setLogin(c.getString(3));

               // usuarios.add(usuario);
            } while (c.moveToNext());
        }
        return usuarios;
    }

    public void excluir(Integer id) {

    }
}
