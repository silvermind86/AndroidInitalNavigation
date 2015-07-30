package com.testes.jonasmagno.navegacao;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.testes.jonasmagno.navegacao.System.Coneccao;

import java.net.ConnectException;


public class AberturaActivity extends ActionBarActivity implements View.OnClickListener{

    Button visualizar;
    Button adicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        visualizar = (Button) findViewById(R.id.visualizarButton);
        visualizar.setOnClickListener(this);
        adicionar = (Button) findViewById(R.id.adicionarButton);
        adicionar.setOnClickListener(this);

        Coneccao con = new Coneccao((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));

        try {
            if(con.checkInternetConnection()){
                Toast.makeText(this.getApplicationContext(),  "Conexão estabelecida.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this.getApplicationContext(),  "Não foi possível estabelecer conexão.", Toast.LENGTH_LONG).show();
            }
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_abertura, menu);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.visualizarButton:
                startActivity(new Intent(this, VisualizarActivity.class));
                break;
            case R.id.adicionarButton:
                startActivity(new Intent(this, AdicionarActivity.class));
                break;
        }
    }
}
