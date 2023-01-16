package com.crudandroid.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.crudandroid.user.dao.UsuarioDao;
import com.crudandroid.user.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // pegar referencia do listViewUsuario
        ListView listView = findViewById(R.id.listViewUsuario);

        ArrayAdapter<Usuario> usuarioArrayAdapter =
                new ArrayAdapter<Usuario>(getApplicationContext(),
                        android.R.layout.simple_list_item_1);

        //capturar informações do banco
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuariosList = usuarioDao.listar();

        // passar os dados da lista para o ArrayAdapter
        usuarioArrayAdapter.addAll(usuariosList);

        // ligacao do listview com o adapter
        listView.setAdapter(usuarioArrayAdapter);

    }
}