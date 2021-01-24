/*
package package com.example.andersonrvalim.jokenpo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionaPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionaPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionaTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        //gerar escolha aleatória para o BOT
        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes[num];

        //chamar método para mostrar imagem do BOT
        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);

        switch (escolhaApp){
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //se o computador ganhar
        if((escolhaApp == "pedra" && escolhaUsuario == "tesoura")||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")
                ){
            txtResultado.setText("Você Perdeu!");
        }else if ((escolhaUsuario == "pedra" && escolhaApp == "tesoura")||
                (escolhaUsuario == "papel" && escolhaApp == "pedra")||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
                ){
            txtResultado.setText("Uhulll Ganhou!");
        }else{
            txtResultado.setText("Ahhh Empatou!");
        }
    }
}
*/
