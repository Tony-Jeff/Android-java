package com.tonyjimaria.exemplooclassesactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadasroFilmeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadasro_filme);
        setContentView(R.layout.activity_main);
    }

        public void chamaPrimeiraTela (View v)
        {
            //chamar a próxima tela (activity)
            Intent invocador = new Intent(this, CadasroFilmeActivity.class);
            startActionMode(invocador);
        }
}
