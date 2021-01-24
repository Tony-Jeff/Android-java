package com.tonyjimaria.cadastrocliente.helper;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.tonyjimaria.cadastrocliente.FormularioActivity;
import com.tonyjimaria.cadastrocliente.R;
import com.tonyjimaria.cadastrocliente.model.bean.Cliente;

public class FormularioHelper {

    private EditText nome;
    private  EditText sobrenome;
    private  EditText telefone;
    private  EditText endereco;
    private  EditText site;
    private  EditText email;

    private Context context;

    private Cliente cliente;


    public FormularioHelper(FormularioActivity activity) {

        nome = (EditText) activity.findViewById(R.id.etNome);
        sobrenome = (EditText) activity.findViewById(R.id.etSobreNome);
        telefone = (EditText) activity.findViewById(R.id.etTelefone);
        endereco = (EditText) activity.findViewById(R.id.etEndereco);
        site = (EditText) activity.findViewById(R.id.etSite);
        email = (EditText) activity.findViewById(R.id.etEmail);

        context =activity.getApplicationContext();

        cliente = new Cliente();
    }

    public Cliente getCliente() {

        if(nome.getText().toString().length()>0){
            if(sobrenome.getText().toString().length()>0){
                if(telefone.getText().toString().length()>0){
                    if(endereco.getText().toString().length()>0){
                        if(site.getText().toString().length()>0){
                            if(email.getText().toString().length()>0){

                                cliente.setNome(nome.getText().toString());
                                cliente.setSobrenome(sobrenome.getText().toString());
                                cliente.setSite(site.getText().toString());
                                cliente.setTelefone(telefone.getText().toString());
                                cliente.setEndereco(endereco.getText().toString());
                                cliente.setEmail(email.getText().toString());

                                nome.setText("");
                                sobrenome.setText("");
                                telefone.setText("");
                                endereco.setText("");
                                site.setText("");
                                email.setText("");

                                return cliente;

                            } else{
                                Toast.makeText(context, "Informe o e-mail", Toast.LENGTH_LONG).show();
                                email.requestFocus();
                            }
                        }else{
                            Toast.makeText(context, "Informe o site", Toast.LENGTH_LONG).show();
                            site.requestFocus();
                        }
                    }else{
                        Toast.makeText(context, "Informe o endereço", Toast.LENGTH_LONG).show();
                        endereco.requestFocus();
                    }
                }else{
                    Toast.makeText(context, "Informe o Telefone", Toast.LENGTH_LONG).show();
                    telefone.requestFocus();
                }
            }else{
                Toast.makeText(context, "Informe o Sobrenome", Toast.LENGTH_LONG).show();
                sobrenome.requestFocus();
            }
        }else{
            Toast.makeText(context,"Informe o Nome", Toast.LENGTH_LONG).show();
            nome.requestFocus();
        }

        return null;
    }


    public void  setCliente(Cliente cliente){
        nome.setText(cliente.getNome());
        sobrenome.setText(cliente.getSobrenome());
        site.setText(cliente.getSite());
        telefone.setText(cliente.getTelefone());
        endereco.setText(cliente.getEndereco());
        email.setText(cliente.getEmail());

        this.cliente = cliente;
    }
}

