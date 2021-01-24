package com.tonyjimaria.exemplooclassesactivities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //instncia da classe filme
    filmes filmes = new filmes();
    EditText nomefilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        nomefilme = findViewById(R.id.edtNome);

    }

    public void mostrarMsg(View view)
    {
        //faz o set no atributo mNoneFilme do objeto filmes com o que foi digitado
        //no campo de texto
        filmes.setmNomeFilme(nomefilme.getText().toString());

        //faz o get no objeto para saber o que foi digitado
        String nome = filmes.getmNomeFilme();

        //chamar a próxima tela (activity)
        Intent invocador = new Intent(this, CadasroFilmeActivity.class);
        invocador.putExtra("filme"this.filmes);
        startActivity(invocador);

    }
}
