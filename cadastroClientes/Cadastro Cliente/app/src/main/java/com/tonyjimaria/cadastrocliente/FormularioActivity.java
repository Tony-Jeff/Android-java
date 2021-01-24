package com.tonyjimaria.cadastrocliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tonyjimaria.cadastrocliente.helper.FormularioHelper;
import com.tonyjimaria.cadastrocliente.model.bean.Cliente;
import com.tonyjimaria.cadastrocliente.model.dao.Dao;

public class FormularioActivity extends AppCompatActivity {


    private FormularioHelper helper;
    private Button btSalvar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);
        btSalvar = (Button) findViewById(R.id.btSalvar);

        //helper.getCliente();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente cliente = helper.getCliente();
                if (cliente!=null){
                    Dao dao = new Dao(FormularioActivity.this);
                    dao.cadastrarCliente(cliente);
                    dao.close();
                    Toast.makeText(getApplicationContext(),"Cliente cadastrado", Toast.LENGTH_LONG).show();
                }


                //helper.getCliente();

            }
        });

    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_a:
                Intent intent = new Intent(FormularioActivity.this,ListaClientesActivity.class);
                startActivity(intent);
                //Toast.makeText(FormularioActivity.this,"Você clicou no item A",Toast.LENGTH_LONG).show();
                return  false;
            case R.id.menu_b:
                Toast.makeText(FormularioActivity.this,"Você clicou no item b",Toast.LENGTH_LONG).show();
                return  false;
            case R.id.menu_c:
                Toast.makeText(FormularioActivity.this,"Você clicou no item c",Toast.LENGTH_LONG).show();
                return  false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
