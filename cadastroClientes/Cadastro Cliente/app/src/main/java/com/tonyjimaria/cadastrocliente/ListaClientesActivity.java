package com.tonyjimaria.cadastrocliente;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tonyjimaria.cadastrocliente.adapter.ListaClientesAdapter;
import com.tonyjimaria.cadastrocliente.model.bean.Cliente;
import com.tonyjimaria.cadastrocliente.model.dao.Dao;


import java.util.ArrayList;
import java.util.List;

public class ListaClientesActivity extends AppCompatActivity {

    //Atributos
        //private EditText etNome;
        //private Button btCadastro;
    private ListView lvClientes;

    //Coleção de Clientes a serem exibidos na tela
    private List<Cliente> listaClientes;

    //converter a lista em View
    private ListaClientesAdapter adapter;

    //cliente selecionado
    private Cliente clienteSelecionado = null;

    //definição do estilo da listagem
        //private int adapterLayout = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        //ligação dos compomentes de tela com os atributos
        lvClientes = (ListView) findViewById(R.id.lvClientes);

        //Registrar o menu de contexto
        registerForContextMenu(lvClientes);

        lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        lvClientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

               clienteSelecionado = (Cliente) adapter.getItem(position);
               return false;
            }
        });



    }

    private void carregarListaClientes(){
        Dao dao = new Dao(this);
        this.listaClientes = dao.listarCliente();
        dao.close();
        this.adapter = new ListaClientesAdapter(listaClientes,this);
        this.lvClientes.setAdapter(adapter);

    }

    private void excluirCliente(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirma a exclusao de: " + clienteSelecionado.getNome());
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            Dao dao = new Dao (ListaClientesActivity.this);
            dao.deletarCliente(clienteSelecionado);
            dao.close();
            carregarListaClientes();
            clienteSelecionado = null;
            }
        });

        builder.setNegativeButton("não", null);
        AlertDialog dialog = builder.create();
        dialog.setTitle("Confirmação de Exclusão");
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarListaClientes();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contexto,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.deletar:
                excluirCliente();
            break;

            case R.id.ligar:
                if (ActivityCompat.checkSelfPermission
                        (this, Manifest.permission.CALL_PHONE)
                        !=PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(ListaClientesActivity.this,
                            "Erro ao tentar efetuar ligação, confira suas permissões!", Toast.LENGTH_LONG).show();
                }else {
                    intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + clienteSelecionado.getTelefone()));
                    startActivity(intent);
                }
                break;

            case R.id.sms:
                intent = new Intent (Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"+clienteSelecionado.getTelefone()));
                intent.putExtra("sms_body", "Mensagem de Boas vindas!");
                startActivity(intent);
                    break;

            case R.id.mapa:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?z=14&q=" + clienteSelecionado.getEndereco()));
                startActivity(intent);
                    break;

            case R.id.site:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://" + clienteSelecionado.getSite()));
                startActivity(intent);
                break;

            case R.id.email:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { clienteSelecionado.getEmail() });
                intent.putExtra(Intent.EXTRA_SUBJECT, "SENAC - Android");
                intent.putExtra(Intent.EXTRA_TEXT, "Aqui vai o Texto");
                startActivity(intent);
                break;

            case R.id.rota:
                Uri gmmInterUri = Uri.parse("google.navigation:q=" + clienteSelecionado.getEndereco());
                Intent mapInter = new Intent(Intent.ACTION_VIEW, gmmInterUri);
                mapInter.setPackage("com.google.android.apps.maps");
                startActivity(mapInter);
                    break;
                default:
                    break;
        }


        return super.onContextItemSelected(item);
    }
}
