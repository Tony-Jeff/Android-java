package com.tonyjimaria.cadastrocliente.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.tonyjimaria.cadastrocliente.model.bean.Cliente;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper{

    private static final int VERSAO = 1;
    private static final String TABELA = "Cliente";
    private static final String DATABASE = "Senac";

    public Dao(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl = "CREATE TABLE " + TABELA + " ( "
                + "id INTEGER PRIMARY KEY, "
                + "nome TEXT, sobrenome TEXT, "
                + "email TEXT, site TEXT, "
                + "endereco TEXT, telefone TEXT)";
        db.execSQL(ddl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public void cadastrarCliente(Cliente cliente){

        ContentValues values = new ContentValues();

        values.put("nome", cliente.getNome());
        values.put("sobrenome", cliente.getSobrenome());
        values.put("email", cliente.getEmail());
        values.put("site", cliente.getSite());
        values.put("endereco", cliente.getEndereco());
        values.put("telefone", cliente.getTelefone());

        getWritableDatabase().insert(TABELA, null, values);


    }
    public List<Cliente> listarCliente(){
    List<Cliente> lista = new ArrayList<Cliente>();
    String sql = "SELECT * FROM " + TABELA + " ORDER BY nome";
    Cursor cursor = getReadableDatabase().rawQuery(sql,null);
    try{
        while (cursor.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(cursor.getLong(0));
            cliente.setNome(cursor.getString(1));
            cliente.setSobrenome(cursor.getString(2));
            cliente.setEmail(cursor.getString(3));
            cliente.setSite(cursor.getString(4));
            cliente.setEndereco(cursor.getString(5));
            cliente.setTelefone(cursor.getString(6));
            lista.add(cliente);
        }
    }catch (SQLException e){
        Log.e("ERRO NA LISTAGEM", e.getMessage());
    }finally{
        cursor.close();
    }
    return lista;
}
public void deletarCliente(Cliente cliente){
     String[] args = {cliente.getId().toString()};
     getWritableDatabase().delete(TABELA, "id=?", args);
     Log.i("CLIENTE","CLIENTE DELETADO: "+cliente.getNome());
    }
}