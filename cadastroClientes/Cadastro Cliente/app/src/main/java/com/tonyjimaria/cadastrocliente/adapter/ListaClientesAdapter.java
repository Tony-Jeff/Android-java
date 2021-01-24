package com.tonyjimaria.cadastrocliente.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tonyjimaria.cadastrocliente.R;
import com.tonyjimaria.cadastrocliente.model.bean.Cliente;

import java.util.List;

public class ListaClientesAdapter extends BaseAdapter{

    private final List<Cliente> listaDeCliente;
    private final Activity activity;

    public ListaClientesAdapter(List<Cliente> listaDeCLiente, Activity activity) {
        this.listaDeCliente = listaDeCLiente;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaDeCliente.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDeCliente.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaDeCliente.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewGeral = activity.getLayoutInflater().inflate(R.layout.item,null);

        Cliente cliente = listaDeCliente.get(position);

        TextView nome = (TextView) viewGeral.findViewById(R.id.itemNome);
        TextView sobrenome = (TextView) viewGeral.findViewById(R.id.itemSobrenome);

        nome.setText(cliente.getNome());
        sobrenome.setText(cliente.getSobrenome());

        return viewGeral;
    }
}
