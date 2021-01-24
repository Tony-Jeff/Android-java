package com.tonyjimaria.frasefeita;

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
    public void novaFrase (View view){
        String[] frases = {
                "Baby baby do baby do biruleibe leibe?",
                "biruleibe leibe??",
                "Do biruleibe leibe???",
                "biruleibe leibe????",
                "do biruleibe leibe?????",
                "biruleibe leibe??????",
                "(Ah, vai te tomar no cu rapá)",
        };
        int num = new Random().nextInt(frases.length);
        TextView texto = findViewById(R.id.txtFrase);
        texto.setText(frases[num]);
    }
}
