package com.example.joaorgreis.lerjson;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    private Button botao;
    private ImageView foto;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        texto = (TextView) findViewById(R.id.txtConectado);

        botao = (Button) findViewById(R.id.btHome);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



        if(checkInternetConnection()==true){
            texto.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Você está conectado", Toast.LENGTH_LONG).show();
        } else{



            botao.setVisibility(View.INVISIBLE);
            texto.setText("Você não está conectado ");
        }
    }





    private boolean checkInternetConnection(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(HomeActivity.CONNECTIVITY_SERVICE);
        if(cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isConnected()){
            return true;
        } else {
            Log.v("CONEXAO", "Sem conexão");
            return false;
        }
    }


}
