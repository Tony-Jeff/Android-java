package com.tonyjimaria.estacomsorte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sorteiaNum (View view) {
        TextView txtResultado = findViewById(R.id.txtResultado);
        int num = new Random().nextInt(6);
        txtResultado.setText("Sorte do dia: " + num);
    }
}
