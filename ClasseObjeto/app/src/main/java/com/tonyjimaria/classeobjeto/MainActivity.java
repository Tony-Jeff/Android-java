package com.tonyjimaria.classeobjeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String = nome "Tony"
        Casa minhaCasa = new Casa();
        minhaCasa.cor = "Vermelho";
        minhaCasa.donoCasa = "Tony";
        System.out.println(minhaCasa.cor); //Exibindo a propriedade
        System.out.println(minhaCasa.donoCasa);

        //acessando o método
        minhaCasa.abrirPorta(); //Chamando o método
    }
}
