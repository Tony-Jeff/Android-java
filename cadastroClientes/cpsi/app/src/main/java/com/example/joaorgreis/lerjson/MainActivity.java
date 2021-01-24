package com.example.joaorgreis.lerjson;

import android.Manifest;
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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.joaorgreis.lerjson.model.bean.Cliente;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoadJSONTask.Listener, AdapterView.OnItemLongClickListener{





    private ListView mListView;
    public static final String URL = "http://brunoop.000webhostapp.com/clientes.php";
    private List<HashMap<String, String>> mClienteMapList = new ArrayList<>();
    private static final String KEY_ID = "id";
    private static final String KEY_NOME = "nome";
    private static final String KEY_SOBRENOME = "sobrenome";
    private static final String KEY_ENDERECO = "endereco";
    private static final String KEY_TELEFONE = "telefone";
    private static final String KEY_SITE = "site";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_IMGURL = "imgUrl";




    private String telefone = null;
    private String email = null;
    private String site = null;
    private String endereco = null;
    private  String nome = null;
    private String id = null;
    private  ListAdapter adapter;

    private AdapterView<?> itemView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lvClientes);
        registerForContextMenu(mListView);
        mListView.setOnItemLongClickListener(this);
        new LoadJSONTask(this).execute(URL);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public void onLoaded(List<Cliente> clienteList) {
        for (Cliente cliente : clienteList) {
            HashMap<String, String> map = new HashMap<>();
            map.put(KEY_ID, cliente.getId());
            map.put(KEY_NOME, cliente.getNome() +" "+ cliente.getSobrenome());
            map.put(KEY_SOBRENOME, cliente.getSobrenome());
            map.put(KEY_ENDERECO, cliente.getEndereco());
            map.put(KEY_TELEFONE, cliente.getTelefone());
            map.put(KEY_SITE, cliente.getSite());
            map.put(KEY_EMAIL, cliente.getEmail());
            map.put(KEY_IMGURL,cliente.getImgUrl());

            mClienteMapList.add(map);
        }
        loadListView();
    }

    private void loadListView() {


       adapter =
                new MyAdapter(
                        MainActivity.this,
                        mClienteMapList,
                        R.layout.item,
                new String[] { KEY_ID, KEY_NOME, KEY_SOBRENOME,KEY_ENDERECO,KEY_TELEFONE,KEY_SITE,KEY_EMAIL,KEY_IMGURL },
                new int[] { R.id.itemId,R.id.itemNome, R.id.itemSobrenome,R.id.itemEndereco,R.id.itemTelefone,R.id.itemSite,R.id.itemEmail,R.id.itemImagem });
        mListView.setAdapter(adapter);


    }

    @Override
    public void onError() {
        Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {

        Intent intent;
        switch (item.getItemId()){

            case R.id.Ligar:
                if(ActivityCompat.checkSelfPermission
                        (this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"Erro ao efetuar ligação, confira suas permissões!",Toast.LENGTH_LONG).show();
                } else {
                    intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + telefone.toString()));
                    startActivity(intent);
                }
                break;
            case  R.id.sms:
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS) !=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this,"Erro ao tentar enviar mensagem SMS, confira suas permissões!",Toast.LENGTH_SHORT).show();
                }else {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:" + telefone.toString()));
                    intent.putExtra("sms_body", "Por favor, entre em contato com nossa empresa!");
                    startActivity(intent);
                }
                break;
            case R.id.mapa:
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: 0,0?z=14&q=" + endereco.toString()));
                startActivity(intent);
                break;
            case R.id.site:
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http:/" + site.toString()));
                startActivity(intent);
                break;
            case R.id.email:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,"SENAC - Android");
                intent.putExtra(Intent.EXTRA_TEXT,"Aqui vai o texto");
                startActivity(intent);
                break;

            case R.id.rota:
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + endereco.toString());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;

            case R.id.whatsapp:
                PackageManager pm=getPackageManager();
                try {
                    String toNumber = telefone.toString();
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?text=" +"Olá entre em contato conosco."));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Instale o Whatsapp",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.deletar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Confirma a exclusão de: " + nome.toString());
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                                String url = "http://brunoop.000webhostapp.com/del_cliente.php?id=" + id.toString();
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                //Toast.makeText(MainActivity.this, "Resposta: " + response.substring(0, 500), Toast.LENGTH_SHORT).show();
                                                //new LoadJSONTask(MainActivity.this).execute(URL);
                                               itemView.setVisibility(View.INVISIBLE);

                                            }
                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(MainActivity.this, "Erro ao deletar cliente", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                queue.add(stringRequest);
                            }
                        });
                builder.setNegativeButton("Não",null);
                    AlertDialog dialog = builder.create();
                dialog.setTitle("Confirmação de Exclusão");
                dialog.show();
                    default:
                            break;

                }

                return super.onContextItemSelected(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        endereco = mClienteMapList.get(i).get(KEY_ENDERECO);
        telefone = mClienteMapList.get(i).get(KEY_TELEFONE);
        site = mClienteMapList.get(i).get(KEY_SITE);
        email = mClienteMapList.get(i).get(KEY_EMAIL);
        nome = mClienteMapList.get(i).get(KEY_NOME);
        id = mClienteMapList.get(i).get(KEY_ID);
        itemView = adapterView;
        return false;
    }
}
