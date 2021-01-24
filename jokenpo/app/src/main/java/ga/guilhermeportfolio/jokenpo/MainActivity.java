package ga.guilhermeportfolio.jokenpo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgResultado;
    TextView txtResultado, txtPontoJogador, txtPontoAdversario;
    ImageView imgJogador;
    MediaPlayer perfect, win, lose;
    public static int ptJogador = 0;
    public static int ptAdversario = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // chamar o método para mostrar a imagem -> criar referencias por id
        imgResultado = findViewById(R.id.imgResultado);
        txtResultado = findViewById(R.id.txtResultado);
        imgJogador = findViewById(R.id.imgJogador);
        txtPontoJogador = findViewById(R.id.txtPontoJogador);
        txtPontoAdversario = findViewById(R.id.txtPontoAdversario);
    }

    public void selecionaPedra(View view){
        imgJogador.setImageResource(R.drawable.pedra);
        this.opcaoSelecionada("pedra");
    }

    public void selecionaPapel(View view){
        imgJogador.setImageResource(R.drawable.papel);
        this.opcaoSelecionada("papel");
    }

    public void selecionaTesoura(View view){
        imgJogador.setImageResource(R.drawable.tesoura);
        this.opcaoSelecionada("tesoura");
    }



    public void opcaoSelecionada (String escolhaUsuario){
        // gerar um número aleatório para escolha do aplicativo
        int num = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[num];

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

        //AUDIOS
        win = MediaPlayer.create(this, R.raw.youwin);
        lose = MediaPlayer.create(this, R.raw.youlose);
        perfect = MediaPlayer.create(this, R.raw.perfect);

        // teste logico para ver quem venceu
        if(escolhaUsuario == escolhaApp){
            txtResultado.setText("EMPATE!");
            perfect.start();
        }else if(escolhaUsuario == "pedra" && escolhaApp == "tesoura"){
            txtResultado.setText("VOCÊ VENCEU!!!");

        } else if(escolhaUsuario == "tesoura" && escolhaApp == "papel"){
            txtResultado.setText("VOCÊ VENCEU!!!");

        } else if(escolhaUsuario == "papel" && escolhaApp == "pedra"){
            txtResultado.setText("VOCÊ VENCEU!!!");
        }else{
            txtResultado.setText("VOCÊ PERDEU!");
        }


        switch(txtResultado.getText().toString()){
            case "VOCÊ VENCEU!!!":
                ptJogador = ptJogador + 1;
                txtPontoJogador.setText("" + ptJogador);
                win.start();
                break;
            case "VOCÊ PERDEU!":
                ptAdversario = ptAdversario + 1;
                txtPontoAdversario.setText("" + ptAdversario);
                lose.start();
                break;

        }
    }
}
