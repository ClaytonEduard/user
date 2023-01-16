package com.crudandroid.user;

import android.content.Intent;
import android.os.Bundle;

import com.crudandroid.user.dao.UsuarioDao;
import com.crudandroid.user.entity.Usuario;
import com.crudandroid.user.sqlite.conexao;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.crudandroid.user.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // metodo salvar

    public void salvar(View view) {
        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtLogin = findViewById(R.id.txtLogin);
        EditText txtSenha = findViewById(R.id.txtSenha);

        // passar os dados para um usuario
        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText().toString());
        usuario.setLogin(txtLogin.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());

        UsuarioDao dao = new UsuarioDao();
        dao.salvar(usuario);

        // imprimir mensagem na tela
        Toast.makeText(getApplicationContext(),
                "Usuário salvo",
                Toast.LENGTH_LONG).show();

    }

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

            Intent intent = new Intent(this, ListActivity.class);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                startActivity(intent);
            }
        });

        //criar o banco de dados  e a instancia
        new conexao(getApplicationContext(),
                "crud.db",
                null,
                1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}